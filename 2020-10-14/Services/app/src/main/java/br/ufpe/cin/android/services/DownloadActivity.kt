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
            "https://s2.glbimg.com/ewTZ730yc9HEP8oQHaw29PHRVMM=/235x133/top/smart/filters:strip_icc()/s2.glbimg.com/SbtkGF6XOnIOmnw-aSgRbozRoSE=/0x0:1280x718/267x150/s.glbimg.com/en/ho/f/original/2020/10/14/8829874_x720.jpg"
    }

    private val onDownloadComplete : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            botaoDownload.isEnabled = true
            msg_download.visibility = View.INVISIBLE
            Toast.makeText(context, "Terminou o download", Toast.LENGTH_LONG).show()
            context?.startActivity(Intent(context,DownloadViewActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(onDownloadComplete, IntentFilter(DownloadService.DOWNLOAD_COMPLETE))
    }

    override fun onPause() {
        unregisterReceiver(onDownloadComplete)
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download)

        botaoDownload.setOnClickListener {
            botaoDownload.isEnabled = false
            val i = Intent(this, DownloadService::class.java)
            i.data = Uri.parse(downloadLink)
            msg_download.visibility = View.VISIBLE
            DownloadService.enqueueWork(this,i)
        }

        botaoVisualizar.setOnClickListener {
            startActivity(Intent(this, DownloadViewActivity::class.java))
        }
    }

}