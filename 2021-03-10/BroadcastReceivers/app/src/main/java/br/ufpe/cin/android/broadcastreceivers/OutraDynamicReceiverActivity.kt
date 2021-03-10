package br.ufpe.cin.android.broadcastreceivers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityDynamicReceiverBinding

class OutraDynamicReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDynamicReceiverBinding
    private var broadcasts = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviarBroadcastDyn.setOnClickListener {

        }
    }
}