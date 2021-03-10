package br.ufpe.cin.android.broadcastreceivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsMessage
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivitySmsBinding
import com.google.android.material.snackbar.Snackbar

class SMSActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {

    private lateinit var binding: ActivitySmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun checkSMS(intent: Intent) {
        val rawMsgs = intent.extras!!["pdus"] as Array<Any>?
        for (raw in rawMsgs!!) {
            val msg = SmsMessage.createFromPdu(raw as ByteArray, "3gpp")
            if (msg.messageBody.toUpperCase().contains("IF1001")) {
                Toast.makeText(this, "Tem algo que nos interessa no SMS...", Toast.LENGTH_SHORT)
                    .show()
                binding.mensagem.text = "tem a palavra-chave!"
            } else {
                Toast.makeText(this, "Não tem o que nos interessa...", Toast.LENGTH_SHORT).show()
                binding.mensagem.text = "não tem a palavra-chave!"
            }
        }
    }

    fun View.showSnackbar(
        msg: String,
        length: Int,
        actionMessage: CharSequence?,
        action: (View) -> Unit
    ) {
        val snackbar = Snackbar.make(this, msg, length)
        if (actionMessage != null) {
            snackbar.setAction(actionMessage) {
                action(this)
            }.show()
        }
    }

}