package br.ufpe.cin.android.broadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityDynamicReceiverBinding

class DynamicReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDynamicReceiverBinding

    val customReceiver = CustomReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviarBroadcastDyn.setOnClickListener {
            sendBroadcast(Intent(MainActivity.CUSTOM_ACTION))
        }

        binding.enviarOutroBroadcast.setOnClickListener {
            sendBroadcast(Intent(DYN_BROADCAST_ACTION))
        }

        val intentFilter = IntentFilter()
        intentFilter.addAction(MainActivity.CUSTOM_ACTION)
        intentFilter.addAction(DYN_BROADCAST_ACTION)

        registerReceiver(customReceiver,intentFilter)
    }

    override fun onDestroy() {
        //não fazer isso aqui resulta em um resource leak
        unregisterReceiver(customReceiver)
        super.onDestroy()
    }



    companion object {
        val DYN_BROADCAST_ACTION = "br.ufpe.cin.android.broadcasts.dynamic"
    }
}