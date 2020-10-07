package br.ufpe.cin.android.services

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botao_musicPlayer.setOnClickListener { startActivity(Intent(applicationContext, MusicPlayerActivity::class.java)) }

        botao_musicServiceWithoutBinding.setOnClickListener { src: View? -> startActivity(Intent(applicationContext, MusicPlayerNoBindingActivity::class.java)) }

        botao_musicServiceWithBinding.setOnClickListener { src: View? -> startActivity(Intent(applicationContext, MusicPlayerWithBindingActivity::class.java)) }

        botao_serviceMainThread.setOnClickListener { src: View? -> startActivity(Intent(applicationContext, ServiceMainThreadActivity::class.java)) }

        botao_downloadService.setOnClickListener { src: View? -> startActivity(Intent(applicationContext, DownloadActivity::class.java)) }
    }
}