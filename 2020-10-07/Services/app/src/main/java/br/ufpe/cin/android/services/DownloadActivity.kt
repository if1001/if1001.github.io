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
import kotlinx.android.synthetic.main.activity_download.*

class DownloadActivity : AppCompatActivity() {

    companion object {
        val downloadLink =
            "https://www.cin.ufpe.br/~lmt/images/profile.jpg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        botaoDownload.setOnClickListener {

        }

        botaoVisualizar.setOnClickListener {
            startActivity(Intent(this, DownloadViewActivity::class.java))
        }
    }

}