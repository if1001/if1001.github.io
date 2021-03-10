package br.ufpe.cin.android.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityBateriaBinding

class BateriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBateriaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBateriaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerReceiver(onBatteryChanged,IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        unregisterReceiver(onBatteryChanged)
        super.onDestroy()
    }

    private val onBatteryChanged  = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            atualizaStatusBateria(intent)
        }
    }

    private fun atualizaStatusBateria(intent: Intent) {
        val pct = (100 * intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 1)
                / intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1))
        binding.barraCarga.progress = pct
        binding.nivelCarga.text = "$pct%"
        when (intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
            BatteryManager.BATTERY_STATUS_CHARGING -> binding.statusCarga.text =
                "carregando"
            BatteryManager.BATTERY_STATUS_FULL -> {
                val plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
                if (plugged == BatteryManager.BATTERY_PLUGGED_AC
                    || plugged == BatteryManager.BATTERY_PLUGGED_USB
                ) {
                    binding.statusCarga.text = "bateria cheia, plugada"
                } else {
                    binding.statusCarga.text = "bateria cheia, mas descarregando"
                }
            }
            else -> binding.statusCarga.text = "bateria descarregando"
        }

        Toast.makeText(this,"$pct% de bateria",Toast.LENGTH_SHORT).show()
    }
}