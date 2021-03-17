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
    internal var TAG = "MusicPlayerBinding"
    private var isBound = false

    //private lateinit var musicPlayer : MusicPlayerBoundService
    private var musicPlayer: MusicPlayerBoundService? = null
    private lateinit var binding: ActivityMusicPlayerWithBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicPlayerWithBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val i = Intent(this, MusicPlayerBoundService::class.java)
        binding.botaoStartService.setOnClickListener {
            startService(i)
        }
        binding.botaoStopService.setOnClickListener {
            stopService(i)
        }
        binding.botaoBindService.setOnClickListener {

            if (isBound) {
                Toast.makeText(this, "O binding já foi realizado...", Toast.LENGTH_SHORT).show()

            }
            else {
                bindService(i, serviceConnection, Context.BIND_AUTO_CREATE)
                Toast.makeText(this, "Realizando binding...", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botaoUnbindService.setOnClickListener {
            if (isBound) {
                unbindService(serviceConnection)
                isBound = false
                Toast.makeText(this, "Desfazendo binding...", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "O binding já foi desfeito (ou nunca realizado)...", Toast.LENGTH_SHORT).show()
            }
        }
        binding.botaoPlay.setOnClickListener {
            if (isBound) {
                musicPlayer?.playMusic()
            }
        }
        binding.botaoPause.setOnClickListener {
            if (isBound) {
                musicPlayer?.pauseMusic()
            }
        }
        binding.botaoRewind.setOnClickListener {
            if (isBound) {
                musicPlayer?.rewind()
            }
        }
    }

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceDisconnected(name: ComponentName) {
            musicPlayer = null
            isBound = false
        }

        override fun onServiceConnected(name: ComponentName, iBinder: IBinder) {
            val musicBinder = iBinder as MusicPlayerBoundService.MusicBinder
            musicPlayer = musicBinder.service
            isBound = true
        }

    }
}