package br.ufpe.cin.android.services

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL

class DownloadWorker(c:Context, params: WorkerParameters) : Worker(c,params) {
    //garantido de rodar numa thread de background
    override fun doWork(): Result {
        try {
            val root =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            root.mkdirs()

            //pegando o campo data do intent passado
            val linkPassado = inputData.getString(KEY_LINK_URI)
            val uri = Uri.parse(linkPassado)

            //intentData.getLastPathSegment() == profile.jpg
            val output = File(root, uri.lastPathSegment)
            if (output.exists()) {
                output.delete()
            }
            val url = URL(uri.toString())
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
            val outputData = workDataOf(KEY_IMAGEFILE_URI to output.absolutePath)
            return Result.success(outputData)


        } catch (e: IOException) {
            Log.e(javaClass.name, "Exception durante download", e)
            return Result.failure()
        }
    }
}