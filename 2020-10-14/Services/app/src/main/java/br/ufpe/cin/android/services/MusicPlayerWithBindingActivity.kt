package br.ufpe.cin.android.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_music_player_with_binding.*

class MusicPlayerWithBindingActivity : AppCompatActivity() {
    internal var musicPlayerService : MusicPlayerBindingService? = null
    internal var isBound = false
    internal var TAG = "MusicPlayerBinding"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_player_with_binding)
        botaoStartService.setOnClickListener {
            val serviceIntent = Intent(this,MusicPlayerBindingService::class.java)
            startService(serviceIntent)
        }

        botaoStopService.setOnClickListener {
            val serviceIntent = Intent(this,MusicPlayerBindingService::class.java)
            stopService(serviceIntent)
        }

        botaoBindService.setOnClickListener {
            if (!isBound) {
                Toast.makeText(this,"Realizando Binding...",Toast.LENGTH_LONG).show()
                val serviceIntent = Intent(this,MusicPlayerBindingService::class.java)
                bindService(serviceIntent,sConn,Context.BIND_AUTO_CREATE)
            }
            else {
                Toast.makeText(this,"O Binding já foi realizado...",Toast.LENGTH_LONG).show()
            }
        }

        botaoUnbindService.setOnClickListener {
            if (isBound) {
                Toast.makeText(this,"Desfazendo Binding...",Toast.LENGTH_LONG).show()
                unbindService(sConn)
                isBound = false
            }
            else {
                Toast.makeText(this,"O Binding já foi desfeito (ou nunca feito)...",Toast.LENGTH_LONG).show()
            }
        }

        botaoPlay.setOnClickListener {
            if (isBound) {
                musicPlayerService?.playMusic()
            }
        }
        botaoPause.setOnClickListener {
            if (isBound) {
                musicPlayerService?.pauseMusic()
            }
        }
    }

    private val sConn = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, iBinder: IBinder) {
            val binder = iBinder as MusicPlayerBindingService.MusicBinder
            musicPlayerService = binder.service
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            isBound = false
            musicPlayerService = null
        }

    }


    override fun onStop() {
        if (isBound) {
            Toast.makeText(this,"Desfazendo Binding...",Toast.LENGTH_LONG).show()
            unbindService(sConn)
        }
        super.onStop()
    }
}