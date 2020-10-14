package br.ufpe.cin.android.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicPlayerService : Service() {

    private val TAG = "MusicPlayerService"
    private var mPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Criando MusicPlayerService na memória")
        mPlayer = MediaPlayer.create(this, R.raw.moonlightsonata)
        mPlayer?.isLooping = false
        mPlayer?.setOnCompletionListener {
            stopSelf()
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (mPlayer?.isPlaying!!) {
            mPlayer?.seekTo(0)
        }
        else {
            mPlayer?.start()
        }

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "Removendo MusicPlayerService da memória")
        mPlayer?.stop()
        mPlayer?.release()
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
