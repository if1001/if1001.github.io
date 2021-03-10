package br.ufpe.cin.android.broadcastreceivers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityDynamicReceiverBinding

class DynamicReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDynamicReceiverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviarBroadcastDyn.setOnClickListener {

        }

    }

    companion object {
        val DYN_BROADCAST_ACTION = "br.ufpe.cin.android.broadcasts.dynamic"
    }
}