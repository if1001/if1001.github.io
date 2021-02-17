package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.ufpe.cin.android.lifecycle.databinding.ActivityLifecycleBinding
import java.text.SimpleDateFormat
import java.util.*

class LifecycleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        binding = ActivityLifecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoAdicionaTexto.setOnClickListener {
            val oQueFoiDigitado = binding.campoTexto.text
            if (oQueFoiDigitado.isEmpty()) {
                toast("Digite algo, por favor")
            } else {
                binding.textoDigitado.text = oQueFoiDigitado
            }
        }

    }

    fun Any.toast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    private fun atualizaLifecycle(msg: String) {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        val toPrint = "$currentDate $msg"
        val m = binding.lifecycleLog.text.toString()
        Log.d("LifecycleActivity", toPrint)
        binding.lifecycleLog.text = "$toPrint\n$m"
    }

}