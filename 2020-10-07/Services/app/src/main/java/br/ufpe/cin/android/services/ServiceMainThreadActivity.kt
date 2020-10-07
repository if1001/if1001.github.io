package br.ufpe.cin.android.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_service_main_thread.*

class ServiceMainThreadActivity : AppCompatActivity() {

    var numToasts = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_main_thread)

        btn_toast.setOnClickListener {
            numToasts++
            Toast.makeText(
                this,
                "Mensagem do toast ($numToasts)",
                Toast.LENGTH_LONG
            ).show()
        }

        btn_taskMainThread.setOnClickListener {

        }
        btn_StartServiceMainThread.setOnClickListener {

        }
        btn_StopServiceMainThread.setOnClickListener {

        }
    }
}