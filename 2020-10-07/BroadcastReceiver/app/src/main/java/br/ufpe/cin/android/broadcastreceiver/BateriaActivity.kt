package br.ufpe.cin.android.broadcastreceiver

import android.content.Intent
import android.os.BatteryManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bateria.*

class BateriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bateria)
    }

    private fun atualizaStatusBateria(intent: Intent) {
        val pct = (100 * intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 1)
                / intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1))
        barra_carga.progress = pct
        nivel_carga.text = "$pct%"
        when (intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)) {
            BatteryManager.BATTERY_STATUS_CHARGING -> status_carga.text =
                "carregando"
            BatteryManager.BATTERY_STATUS_FULL -> {
                val plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
                if (plugged == BatteryManager.BATTERY_PLUGGED_AC
                    || plugged == BatteryManager.BATTERY_PLUGGED_USB
                ) {
                    status_carga.text = "bateria cheia, plugada"
                } else {
                    status_carga.text = "bateria cheia, mas descarregando"
                }
            }
            else -> status_carga.text = "bateria descarregando"
        }
    }
}