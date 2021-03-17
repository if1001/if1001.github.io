package br.ufpe.cin.android.services

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import br.ufpe.cin.android.services.databinding.ActivityMusicPlayerBinding
import kotlin.random.Random

class MusicPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicPlayerBinding
    private lateinit var mPlayer: MediaPlayer
    private val activityID = Random.nextInt(1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPlayer = MediaPlayer.create(this, R.raw.ghosts)
        binding = ActivityMusicPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.i("MusicPlayerActivity", "ID da Activity: $activityID")

        binding.botaoPlay.setOnClickListener {
            mPlayer.start()
        }

        binding.botaoPause.setOnClickListener {
            if (mPlayer.isPlaying) {
                mPlayer.pause()
            }
        }
    }

    override fun onStop() {
        if (mPlayer.isPlaying) {
            mPlayer.pause()
        }
        super.onStop()
    }

    override fun onDestroy() {
        mPlayer.release()
        super.onDestroy()
    }
}