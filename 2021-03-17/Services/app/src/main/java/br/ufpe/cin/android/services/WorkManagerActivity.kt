package br.ufpe.cin.android.services

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.work.*
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

            binding.msgDownload.visibility = View.VISIBLE

            val data = Data.Builder().putString(KEY_LINK_URI, linkUri?.toString()).build()

            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresCharging(true)
                .setRequiresBatteryNotLow(true)
                .build()

            val downloadRequest =
                OneTimeWorkRequestBuilder<DownloadWorker>()
                    .setInputData(data)
                    .setConstraints(constraints)
                    .build()
            workManager.enqueue(downloadRequest)
            val liveData = workManager.getWorkInfoByIdLiveData(downloadRequest.id)
            liveData.observe(
                this,
                Observer {
                    var success = false
                    var msg = ""

                    when (it.state) {
                        WorkInfo.State.SUCCEEDED -> {
                            msg = "Funcionou!"
                            success = true
                            binding.botaoDownload.isEnabled = true
                        }
                        WorkInfo.State.ENQUEUED -> {
                            msg = "Na fila..."
                        }
                        WorkInfo.State.CANCELLED -> {
                            msg = "Cancelado..."
                            binding.botaoDownload.isEnabled = true
                        }
                        WorkInfo.State.BLOCKED -> {
                            msg = "Bloqueado (aguardando)..."
                        }
                        WorkInfo.State.FAILED -> {
                            msg = "Falhou..."
                            binding.botaoDownload.isEnabled = true
                        }
                        WorkInfo.State.RUNNING -> {
                            msg = "Executando..."
                        }
                    }
                    binding.msgDownload.text = msg
                    Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
                    if (success) {
                        val intent = Intent(applicationContext,WorkManagerViewActivity::class.java)
                        intent.data = Uri.parse(it.outputData.getString(KEY_IMAGEFILE_URI))
                        startActivity(intent)
                    }
                }
            )

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