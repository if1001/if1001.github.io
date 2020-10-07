package br.ufpe.cin.android.broadcastreceiver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dyn_rec.*

class OutraDynRecActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dyn_rec)
        enviarBroadcastDyn.setOnClickListener {

        }
    }

}