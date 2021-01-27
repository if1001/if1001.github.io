package br.ufpe.cin.android.services


import android.content.Context
import android.content.Intent
import android.os.Environment
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
        private val JOB_ID = 123
        val DOWNLOAD_COMPLETE = "br.ufpe.cin.android.service.action.DOWNLOAD_COMPLETE"

        fun enqueueWork(context: Context, intent: Intent) {
            //se quiser pode manipular o intent aqui dentro, antes da chamada abaixo
            enqueueWork(context, DownloadService::class.java, JOB_ID, intent)
        }
    }

    //garantido de rodar em uma thread de background
    //ao terminar de executar este método, o Service se encerra
    override fun onHandleWork(intent: Intent) {
        try {
            //checar se tem permissao... Android 6.0+
            val root =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            root.mkdirs()

            //intent.setData(Uri.parse("https://www.cin.ufpe.br/~lmt/profile.jpg")
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

            sendBroadcast(Intent(DOWNLOAD_COMPLETE))

        } catch (e: IOException) {
            Log.e(javaClass.name, "Exception durante download", e)
        }
    }

}
