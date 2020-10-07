package br.ufpe.cin.android.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        //roda na main thread
        Toast.makeText(context, "Terminou o boot", Toast.LENGTH_LONG).show()
    }
}
