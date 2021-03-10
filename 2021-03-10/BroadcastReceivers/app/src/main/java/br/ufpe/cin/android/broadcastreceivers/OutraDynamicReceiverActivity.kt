package br.ufpe.cin.android.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityDynamicReceiverBinding

class OutraDynamicReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDynamicReceiverBinding
    private var broadcasts = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviarBroadcastDyn.setOnClickListener {
            sendBroadcast(Intent(MainActivity.CUSTOM_ACTION))
        }

        binding.enviarOutroBroadcast.setOnClickListener {
            sendBroadcast(Intent(DynamicReceiverActivity.DYN_BROADCAST_ACTION))
        }

    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.apply {
            addAction(MainActivity.CUSTOM_ACTION)
            addAction(DynamicReceiverActivity.DYN_BROADCAST_ACTION)
        }
        registerReceiver(outroReceiver, intentFilter)
    }

    override fun onPause() {
        unregisterReceiver(outroReceiver)
        super.onPause()
    }

    private val outroReceiver : BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val intentAction = intent.action
            if (intentAction != null) {
                when (intentAction) {
                    MainActivity.CUSTOM_ACTION -> {
                        broadcasts++
                        binding.texto.text = "chegou um broadcast ($broadcasts)"
                    }
                    DynamicReceiverActivity.DYN_BROADCAST_ACTION -> {
                        val i = Intent(context,NovaActivity::class.java)
                        context.startActivity(i)
                    }
                    else -> {
                        Toast.makeText(
                            context,
                            "Chegou alguma outra action: $intentAction",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.texto.text = "chegou algum outro broadcast com outra ação"
                    }
                }
            }
        }
    }
}