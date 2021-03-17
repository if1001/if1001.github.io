package br.ufpe.cin.android.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.os.IBinder
import android.util.Log
import androidx.core.app.JobIntentService
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class DownloadService : JobIntentService() {

    companion object {
        fun enqueue(c:Context, i: Intent) {
            enqueueWork(c, DownloadService::class.java, 1234, i)
        }

        val DOWNLOAD_COMPLETE = "br.ufpe.cin.android.services.DOWNLOAD_COMPLETE"
    }

    //código dentro desse método é garantido de rodar em uma thread de background
    //ao terminar de executar este método, o service se encerra
    override fun onHandleWork(intent: Intent) {
        try {
            val root =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            root.mkdirs()

            //pegando o campo data do intent passado
            val intentData = intent.data

            //intentData.getLastPathSegment() == profile.jpg
            val output = File(root, intentData!!.lastPathSegment)
            if (output.exists()) {
                output.delete()
            }
            val url = URL(intentData.toString())
            val c = url.openConnection() as HttpURLConnection
            val fos = FileOutputStream(output.path)
            val out = BufferedOutputStream(fos)
            try {
                val `in` = c.inputStream
                val buffer = ByteArray(8192)
                var len = 0
                while (`in`.read(buffer).also { len = it } >= 0) {
                    out.write(buffer, 0, len)
                }
                out.flush()
            } finally {
                fos.fd.sync()
                out.close()
                c.disconnect()
            }

            //avisar que terminou
            sendBroadcast(Intent(DOWNLOAD_COMPLETE))


        } catch (e: IOException) {
            Log.e(javaClass.name, "Exception durante download", e)
        }
    }
}