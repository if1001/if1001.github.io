package br.ufpe.cin.android.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dyn_rec.*

class OutraDynRecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dyn_rec)
        enviarBroadcastDyn.setOnClickListener {
            sendBroadcast(Intent(DynRecActivity.DYN_BROADCAST_ACTION))
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(outroDynamicReceiver, IntentFilter(DynRecActivity.DYN_BROADCAST_ACTION))
    }

    override fun onStop() {
        unregisterReceiver(outroDynamicReceiver)
        super.onStop()
    }

    private val outroDynamicReceiver : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Broadcast recebido dinamicamente", Toast.LENGTH_LONG).show()
            texto.text = "chegou um broadcast dinâmico"
        }
    }


}