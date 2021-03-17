package br.ufpe.cin.android.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import br.ufpe.cin.android.services.databinding.ActivityMusicPlayerWithBindingBinding

class MusicPlayerWithBindingActivity : AppCompatActivity() {
    internal var isBound = false
    internal var TAG = "MusicPlayerBinding"

    private lateinit var binding: ActivityMusicPlayerWithBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicPlayerWithBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botaoStartService.setOnClickListener {
        }
        binding.botaoStopService.setOnClickListener {
        }
        binding.botaoBindService.setOnClickListener {
        }
        binding.botaoUnbindService.setOnClickListener {
        }
        binding.botaoPlay.setOnClickListener {
        }
        binding.botaoPause.setOnClickListener {
        }
    }
}