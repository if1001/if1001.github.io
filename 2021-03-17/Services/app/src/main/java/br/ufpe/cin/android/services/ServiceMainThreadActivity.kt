package br.ufpe.cin.android.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufpe.cin.android.services.databinding.ActivityServiceMainThreadBinding

class ServiceMainThreadActivity : AppCompatActivity() {

    var numToasts = 0;
    private lateinit var binding: ActivityServiceMainThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceMainThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            numToasts++
            Toast.makeText(
                this,
                "Mensagem do toast ($numToasts)",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.btnTaskMainThread.setOnClickListener {
            try {
                Thread.sleep(4000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        binding.btnStartServiceMainThread.setOnClickListener {

        }
        binding.btnStopServiceMainThread.setOnClickListener {

        }
    }
}