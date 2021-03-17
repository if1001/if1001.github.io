package br.ufpe.cin.android.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MainThreadService : Service() {

    //roda quando o objeto está sendo criado
    override fun onCreate() {
        super.onCreate()
        Log.i("MainThreadService","Criando o Service na memória")
    }

    //roda toda vez que chama startService()
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        //código aqui dentro roda na UI/Main thread por padrão
        //se for fazer operação de rede ou acessar BD, etc. - precisa rodar em uma background thread
        val valor = intent?.getStringExtra("chave")
        Log.i("MainThreadService", "Rodou o onStartCommand : $valor")
        try {
            Thread.sleep(4000)
        }
        catch (e:InterruptedException) {
            e.printStackTrace()
        }
        Log.i("MainThreadService","Após o Thread.sleep")
        //sinalizando o que fazer caso o Service seja interrompido pelo sistema
        //START_NOT_STICKY
        //START_STICKY
        //START_REDELIVER_INTENT
        return super.onStartCommand(intent, flags, startId)
    }

    //roda quando o objeto está sendo destruído
    override fun onDestroy() {
        Log.i("MainThreadService","Liberando o Service da memória (destruindo)")
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}