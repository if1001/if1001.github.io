package br.ufpe.cin.android.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.android.services.databinding.ActivityDownloadBinding

class DownloadActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDownloadBinding

    companion object {
        val downloadLink =
            "https://s2.glbimg.com/ir8i3zpJ8lfVOxZDqjF3CZliblQ=/0x0:2048x1536/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2021/C/8/EBby74QzWxnqtfTFbVfA/51036467213-17b0dfdcdc-k.jpg"
    }

    private val onDownloadCompleted = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            binding.botaoDownload.isEnabled = true
            binding.botaoVisualizar.isEnabled = true
            Toast.makeText(context,"Terminou download",Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context,DownloadViewActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        registerReceiver(onDownloadCompleted, IntentFilter(DownloadService.DOWNLOAD_COMPLETE))
    }

    override fun onPause() {
        unregisterReceiver(onDownloadCompleted)
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoDownload.setOnClickListener {
            binding.botaoDownload.isEnabled = false
            binding.botaoVisualizar.isEnabled = false

            val i = Intent(this, DownloadService::class.java)
            i.data = Uri.parse(downloadLink)
            DownloadService.enqueue(this,i)
        }

        binding.botaoVisualizar.setOnClickListener {
            startActivity(Intent(this, DownloadViewActivity::class.java))
        }
    }

}