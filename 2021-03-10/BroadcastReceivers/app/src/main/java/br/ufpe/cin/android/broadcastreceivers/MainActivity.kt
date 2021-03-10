package br.ufpe.cin.android.broadcastreceivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.enviarBroadcast.setOnClickListener {
            sendBroadcast(Intent(CUSTOM_ACTION))
        }
        binding.abrirActivity.setOnClickListener {
            startActivity(Intent(this, DynamicReceiverActivity::class.java))
        }
        binding.abrirOutraActivity.setOnClickListener {
            startActivity(Intent(this, OutraDynamicReceiverActivity::class.java))
        }
        binding.bateriaActivity.setOnClickListener {
            startActivity(Intent(this, BateriaActivity::class.java))
        }
        binding.smsActivity.setOnClickListener {
            startActivity(Intent(this, SMSActivity::class.java))
        }
    }
    companion object {
        val CUSTOM_ACTION = "br.ufpe.cin.android.broadcast.ACTION_X"
    }
}