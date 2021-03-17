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
            "https://s2.glbimg.com/ewTZ730yc9HEP8oQHaw29PHRVMM=/235x133/top/smart/filters:strip_icc()/s2.glbimg.com/SbtkGF6XOnIOmnw-aSgRbozRoSE=/0x0:1280x718/267x150/s.glbimg.com/en/ho/f/original/2020/10/14/8829874_x720.jpg"
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoDownload.setOnClickListener {
            binding.botaoDownload.isEnabled = false
        }

        binding.botaoVisualizar.setOnClickListener {
            startActivity(Intent(this, DownloadViewActivity::class.java))
        }
    }

}