package br.ufpe.cin.android.services

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.android.services.databinding.ActivityMusicPlayerNoBindingBinding

class MusicPlayerNoBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMusicPlayerNoBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicPlayerNoBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = Intent(this,MusicPlayerService::class.java)
        binding.btnStartService.setOnClickListener {
            startService(i)
        }
        binding.btnStopService.setOnClickListener {
            stopService(i)
        }
    }

}
