package br.ufpe.cin.android.services

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import br.ufpe.cin.android.services.databinding.ActivityDownloadBinding

class WorkManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDownloadBinding
    private var linkUri: Uri? = null
    private var outputUri: Uri? = null
    private lateinit var workId: String

    private val workManager = WorkManager.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botaoVisualizar.visibility = View.GONE
        binding.botaoDownload.setOnClickListener {
            binding.botaoDownload.isEnabled = false
            if (binding.linkDownload.text.isEmpty()) {
                setLinkUri(DownloadActivity.downloadLink)
            } else {
                setLinkUri(binding.linkDownload.text.toString())
            }

        }
    }

    private fun uriOrNull(uriString: String?): Uri? {
        return if (!uriString.isNullOrEmpty()) {
            Uri.parse(uriString)
        } else {
            null
        }
    }

    /**
     * Setters
     */
    internal fun setLinkUri(uri: String?) {
        linkUri = uriOrNull(uri)
    }

    internal fun setOutputUri(outputImageUri: String?) {
        outputUri = uriOrNull(outputImageUri)
    }
}