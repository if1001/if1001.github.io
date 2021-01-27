package br.ufpe.cin.android.services

import android.app.*
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MusicPlayerBindingService : Service() {

    private val TAG = "MusicPlayerService"
    private var mPlayer: MediaPlayer? = null
    private val mStartID: Int = 1
    val CHANNEL_ID = "Music Player Notification"

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Criando MusicPlayerService na memória")
        mPlayer = MediaPlayer.create(this, R.raw.moonlightsonata)
        mPlayer?.isLooping = true

        createChannel()

        val notificationIntent = Intent(this, MusicPlayerWithBindingActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,0)
        val notification : Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setOngoing(true)
            .setContentTitle("Music Service está rodando")
            .setContentText("Clique para acessar o player")
            .setContentIntent(pendingIntent)
            .build()

        startForeground(NOTIFICATION_ID,notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
    }

    fun playMusic() {
        if (!mPlayer?.isPlaying!!) {
            mPlayer?.start()
        }
    }

    fun pauseMusic() {
        if (mPlayer?.isPlaying!!) {
            mPlayer?.pause()
        }
    }

    override fun onDestroy() {
        Log.d(TAG, "Removendo MusicPlayerService da memória")
        mPlayer?.stop()
        mPlayer?.release()
        super.onDestroy()
    }

    inner class MusicBinder : Binder() {
        val service : MusicPlayerBindingService
            get() = this@MusicPlayerBindingService
    }

    private val musicBinder : IBinder = MusicBinder()

    override fun onBind(intent: Intent): IBinder {
        return musicBinder
    }



    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val mChannel = NotificationChannel(
                CHANNEL_ID,
                "Canal de Notificacoes",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            mChannel.description = "Descricao"
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }
    companion object {
        private val NOTIFICATION_ID = 2
        val START_FOREGROUND_SERVICE = "START_FOREGROUND_SERVICE"
        val STOP_FOREGROUND_SERVICE = "STOP_FOREGROUND_SERVICE"
    }
}
