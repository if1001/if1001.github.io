package br.ufpe.cin.android.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dyn_rec.*

class DynRecActivity : AppCompatActivity() {

    companion object {
        val DYN_BROADCAST_ACTION = "br.ufpe.cin.android.broadcasts.dinamico"
    }

    private val dynamicReceiver = DynamicReceiver()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dyn_rec)
        enviarBroadcastDyn.setOnClickListener {
            sendBroadcast(Intent(DYN_BROADCAST_ACTION))
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(dynamicReceiver, IntentFilter(DYN_BROADCAST_ACTION))
    }

    override fun onPause() {
        //se esquecer de fazer isso aqui, o sistema vai reclamar (observe o logcat)
        unregisterReceiver(dynamicReceiver)
        super.onPause()
    }



}