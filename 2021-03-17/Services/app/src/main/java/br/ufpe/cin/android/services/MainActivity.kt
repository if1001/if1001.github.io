package br.ufpe.cin.android.services

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.android.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoMusicPlayer.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    MusicPlayerActivity::class.java
                )
            )
        }

        binding.botaoMusicServiceWithoutBinding.setOnClickListener {
            startActivity(
                Intent(applicationContext, MusicPlayerNoBindingActivity::class.java)
            )
        }

        binding.botaoMusicServiceWithBinding.setOnClickListener {
            startActivity(
                Intent(applicationContext, MusicPlayerWithBindingActivity::class.java)
            )
        }
        binding.botaoAnotherBinding.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    AnotherBindingActivity::class.java
                )
            )
        }

        binding.botaoServiceMainThread.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    ServiceMainThreadActivity::class.java
                )
            )
        }

        binding.botaoDownloadService.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    DownloadActivity::class.java
                )
            )
        }

        binding.botaoWorkManager.setOnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    WorkManagerActivity::class.java
                )
            )
        }


    }
}