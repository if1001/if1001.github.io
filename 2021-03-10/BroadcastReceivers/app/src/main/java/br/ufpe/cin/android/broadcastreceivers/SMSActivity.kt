package br.ufpe.cin.android.broadcastreceivers

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsMessage
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivitySmsBinding
import com.google.android.material.snackbar.Snackbar

class SMSActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {

    companion object {
        private val SMS_PERMISSION = Manifest.permission.RECEIVE_SMS
        private val SMS_REQUEST_CODE = 123
        private val SMS_PERMISSION_ARRAY = arrayOf(SMS_PERMISSION)

    }

    private lateinit var binding: ActivitySmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerReceiver(onSMS, IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION))
        if (!podeSMS()) {
            solicitarPermissaoSMS()
        }
    }

    fun solicitarPermissaoSMS() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, SMS_PERMISSION)) {
            binding.mainLayout.showSnackbar(
                "Precisamos de acesso às mensagens de SMS para monitorar nesta Activity...",
                Snackbar.LENGTH_INDEFINITE,
                "Ok"
            ) { ActivityCompat.requestPermissions(this, SMS_PERMISSION_ARRAY, SMS_REQUEST_CODE) }
        }
        else {
            ActivityCompat.requestPermissions(this, SMS_PERMISSION_ARRAY, SMS_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            SMS_REQUEST_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    binding.mainLayout.showSnackbar(
                        "Permissão concedida",
                        Snackbar.LENGTH_SHORT,
                        null,
                        {}
                    )
                } else {
                    binding.mainLayout.showSnackbar(
                        "Permissão SMS não foi concedida",
                        Snackbar.LENGTH_INDEFINITE,
                        "Ok"
                    ) { finish() }
                }

            }
            else -> {
                Toast.makeText(this, "Houve algum erro", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }

    fun podeSMS() = hasPermission(SMS_PERMISSION)

    fun hasPermission(permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(
            applicationContext,
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }


    override fun onDestroy() {
        unregisterReceiver(onSMS)
        super.onDestroy()
    }

    private val onSMS = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            checkSMS(intent)
        }

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