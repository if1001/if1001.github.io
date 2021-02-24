package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufpe.cin.android.background.databinding.ActivityTaskBinding

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding

    var toasts = 0
    val limite = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contadorToasts.text = getString(R.string.contadorToasts,toasts)

        binding.btnToast.setOnClickListener {
            logThread("Callback do Botão do Toast")
            toasts++
            val msg = getString(R.string.contadorToasts,toasts)
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            binding.contadorToasts.text = msg
        }

        binding.btnLongOperation.setOnClickListener {
            logThread("Callback do Botão Long Operation")
        }

        binding.btnNetwork.setOnClickListener {
            logThread("Callback do Botão Network")
        }
    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }

}