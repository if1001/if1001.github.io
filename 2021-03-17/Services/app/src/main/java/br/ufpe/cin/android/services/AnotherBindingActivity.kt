package br.ufpe.cin.android.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.services.databinding.ActivityMusicPlayerWithBindingBinding

class AnotherBindingActivity : AppCompatActivity() {
    internal var isBound = false
    internal var TAG = "MusicPlayerBinding"

    private lateinit var binding : ActivityMusicPlayerWithBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicPlayerWithBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoPlay.setOnClickListener {
        }
        binding.botaoPause.setOnClickListener {
        }
    }
}