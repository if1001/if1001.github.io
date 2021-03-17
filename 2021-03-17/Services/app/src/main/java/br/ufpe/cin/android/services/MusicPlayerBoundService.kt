package br.ufpe.cin.android.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import kotlin.random.Random

class MusicPlayerBoundService : Service() {
    private lateinit var mPlayer: MediaPlayer
    private val serviceID = Random.nextInt(1000)
    private var numStart = 0

    //roda quando o objeto está sendo criado
    override fun onCreate() {
        super.onCreate()
        mPlayer = MediaPlayer.create(this, R.raw.ghosts)
        mPlayer.isLooping = false
        mPlayer.setOnCompletionListener {
            stopSelf()
        }
        Log.i(this.javaClass.simpleName, "Criando o Service na memória ($serviceID)")
    }

    //roda quando o objeto está sendo destruído
    override fun onDestroy() {
        Log.i(this.javaClass.simpleName, "Liberando o Service da memória ($serviceID)")
        mPlayer.release()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        numStart++
        val msg = "${this.javaClass.simpleName} executando agora ($numStart)"
        Log.i(this.javaClass.simpleName, msg)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        return super.onStartCommand(intent, flags, startId)
    }

    fun playMusic() {
        if (!mPlayer.isPlaying) {
            mPlayer.start()
        }
    }

    fun pauseMusic() {
        if (mPlayer.isPlaying) {
            mPlayer.pause()
        }
    }

    fun rewind() {
        if (mPlayer.isPlaying) {
            mPlayer.seekTo(0)
        }
    }

    inner class MusicBinder : Binder() {
        val service: MusicPlayerBoundService
            get() = this@MusicPlayerBoundService
    }

    override fun onBind(intent: Intent): IBinder {
        return MusicBinder()
    }
}