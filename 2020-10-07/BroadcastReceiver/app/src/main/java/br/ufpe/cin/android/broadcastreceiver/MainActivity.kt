package br.ufpe.cin.android.broadcastreceiver

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val BROADCAST_ACTION = "br.ufpe.cin.android.broadcasts.exemplo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enviarBroadcast.setOnClickListener {
            //Disparar uma mensagem, que vai ser transmitida pelo sistema
            //Todos os componentes registrados para receber esta mensagem, vão de fato receber
            sendBroadcast(Intent(BROADCAST_ACTION))
        }

        enviarBroadcastDyn.setOnClickListener {
            sendBroadcast(Intent(DynRecActivity.DYN_BROADCAST_ACTION))
        }

        abrirActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    DynRecActivity::class.java
                )
            )
        }

        abrirOutraActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    OutraDynRecActivity::class.java
                )
            )
        }

        bateriaActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    BateriaActivity::class.java
                )
            )
        }

        smsActivity.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SMSActivity::class.java
                )
            )
        }


    }
}