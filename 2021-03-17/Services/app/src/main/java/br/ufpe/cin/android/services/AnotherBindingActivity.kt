package br.ufpe.cin.android.services

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Toast
import br.ufpe.cin.android.services.databinding.ActivityMusicPlayerWithBindingBinding

class AnotherBindingActivity : AppCompatActivity() {
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
        startService(i)
        binding.botaoStartService.visibility = View.GONE
        binding.botaoStopService.setOnClickListener {
            //só funciona se desfizer binding antes
            stopService(i)
        }
        binding.botaoBindService.visibility = View.GONE
        binding.botaoUnbindService.visibility = View.GONE

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

    override fun onStart() {
        super.onStart()
        if (isBound) {
            Toast.makeText(this, "O binding já foi realizado...", Toast.LENGTH_SHORT).show()
        }
        else {
            bindService(Intent(this, MusicPlayerBoundService::class.java), serviceConnection, Context.BIND_AUTO_CREATE)
            Toast.makeText(this, "Realizando binding...", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        if (isBound) {
            unbindService(serviceConnection)
            isBound = false
            Toast.makeText(this, "Desfazendo binding...", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "O binding já foi desfeito (ou nunca realizado)...", Toast.LENGTH_SHORT).show()
        }
        super.onStop()
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