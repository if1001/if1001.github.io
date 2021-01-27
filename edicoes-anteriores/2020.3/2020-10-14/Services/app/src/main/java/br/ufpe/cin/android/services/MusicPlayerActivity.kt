package br.ufpe.cin.android.services

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_music_player.*

class MusicPlayerActivity : AppCompatActivity() {
    //Jogue o código que inicia a música e toca pra dentro do MusicPlayerService
    private var mPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player)

        mPlayer = MediaPlayer.create(this, R.raw.ghosts)

        botaoPlay.setOnClickListener {
            mPlayer?.start()
        }

        botaoPause.setOnClickListener {
            mPlayer?.pause()
        }
    }

    override fun onStop() {
        mPlayer?.pause()
        super.onStop()
    }

    override fun onDestroy() {
        mPlayer?.release()
        super.onDestroy()
    }
}