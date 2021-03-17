package br.ufpe.cin.android.services

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.android.services.databinding.ActivityDownloadViewBinding
import java.io.File

class DownloadViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val root =
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            val imageFile = File(root, Uri.parse(DownloadActivity.downloadLink).lastPathSegment)
            if (imageFile.exists()) {
                binding.imagemDownload.setImageURI(Uri.parse("file://" + imageFile.absolutePath))
            } else {
                Toast.makeText(this, "Arquivo nao existe", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Armazenamento externo nao esta montado...", Toast.LENGTH_SHORT)
                .show()
        }
    }
}