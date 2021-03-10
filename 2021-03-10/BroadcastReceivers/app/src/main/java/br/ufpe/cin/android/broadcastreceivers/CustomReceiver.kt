package br.ufpe.cin.android.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        //não faça isso aqui... :)
        //Thread.sleep(2000)
        if (intentAction != null) {
            when (intentAction) {
                MainActivity.CUSTOM_ACTION -> Toast.makeText(
                    context,
                    "Chegou custom action",
                    Toast.LENGTH_SHORT
                ).show()
                else -> Toast.makeText(
                    context,
                    "Chegou alguma outra action: $intentAction",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}