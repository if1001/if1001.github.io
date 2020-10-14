package br.ufpe.cin.android.services

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_music_player_no_binding.*

class MusicPlayerNoBindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player_no_binding)

        btn_StartService.setOnClickListener {

        }
        btn_StopService.setOnClickListener {

        }
    }

}
