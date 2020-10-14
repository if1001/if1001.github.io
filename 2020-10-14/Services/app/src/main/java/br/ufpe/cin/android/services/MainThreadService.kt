package br.ufpe.cin.android.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MainThreadService : Service() {

    //roda quando o objeto está sendo criado
    override fun onCreate() {
        super.onCreate()
        Log.d("MainThreadService","Service foi criado na memória")
    }

    //roda quando o objeto está sendo destruído
    override fun onDestroy() {
        Log.d("MainThreadService","Service está sendo destruído")
        super.onDestroy()
    }

    //chamado toda vez que você dá startService()
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //código que roda aqui dentro, roda na Main Thread (UI Thread)
        //se for tentar fazer download, acessar BD, etc. - precisa rodar em uma worker thread
        try {
            Thread.sleep(4000)
        }
        catch (e:InterruptedException) {
            e.printStackTrace()
        }
        //sinaliza o que fazer caso o service seja interrompido
        //START_NOT_STICKY
        //START_STICKY
        //START_REDELIVER_INTENT
        return super.onStartCommand(intent, flags, startId)
    }

    //ignorar por enquanto - serve pra você conectar a Activity com o Service
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}
