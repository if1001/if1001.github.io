package br.ufpe.cin.android.services

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class DownloadViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_view)
        //Não está checando se tem permissão - sugestão de prática/exercício é incluir esta checagem
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val root =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val imageFile = File(root, Uri.parse(DownloadActivity.downloadLink).lastPathSegment)
            if (imageFile.exists()) {
                val imageview = findViewById<ImageView>(R.id.imagemDownload)
                imageview.setImageURI(Uri.parse("file://" + imageFile.absolutePath))
            } else {
                Toast.makeText(this, "Arquivo nao existe", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Armazenamento externo nao esta montado...", Toast.LENGTH_SHORT)
                .show()
        }
    }
}