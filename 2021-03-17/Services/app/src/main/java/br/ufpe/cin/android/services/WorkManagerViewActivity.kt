package br.ufpe.cin.android.services

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.services.databinding.ActivityDownloadViewBinding

class WorkManagerViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadViewBinding
    private var imageUri: Uri? = null
    private var outputUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageUri = intent.data
        binding.imagemDownload.setImageURI(imageUri)
    }

}