package br.ufpe.cin.android.broadcastreceiver

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sms.*

class SMSActivity : AppCompatActivity() {

    companion object {
        private val SMS_PERMISSIONS = arrayOf(
            Manifest.permission.RECEIVE_SMS
        )
        private val SMS_REQUEST = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
        if (!podeSMS()) {
            ActivityCompat.requestPermissions(this, SMS_PERMISSIONS, SMS_REQUEST)
        }
    }

    fun podeSMS(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.RECEIVE_SMS
        ) == PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            SMS_REQUEST -> if (!podeSMS()) {
                Toast.makeText(this, "Sem permissão para SMS", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    private fun checkSMS(intent: Intent) {
        val rawMsgs = intent.extras!!["pdus"] as Array<Any>?
        for (raw in rawMsgs!!) {
            val msg = SmsMessage.createFromPdu(raw as ByteArray)
            if (msg.messageBody.toUpperCase().contains("IF1001")) {
                Toast.makeText(this, "Tem algo que nos interessa...", Toast.LENGTH_SHORT).show()
                mensagem.setText("Tem a palavra chave!")
            } else {
                mensagem.setText("Não tem a palavra chave...")
            }
        }
    }

}