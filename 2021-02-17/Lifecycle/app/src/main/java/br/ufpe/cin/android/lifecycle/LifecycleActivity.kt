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

    //private val CAMPO_TEXTO = "oQueTemNoCampoDeTexto"

    //Activity está sendo criada na memória
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        binding = ActivityLifecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textoDigitado.text = savedInstanceState?.getString("oQueTemNoCampoDeTexto")
        binding.lifecycleLog.text = savedInstanceState?.getString("logLifecycle")

        binding.botaoAdicionaTexto.setOnClickListener {
            val oQueFoiDigitado = binding.campoTexto.text
            if (oQueFoiDigitado.isEmpty()) {
                toast("Digite algo, por favor")
            } else {
                binding.textoDigitado.text = oQueFoiDigitado
            }
        }

        atualizaLifecycle("onCreate()")

    }

    //Activity está sendo removida da memória
    //pode não ser chamado
    override fun onDestroy() {
        atualizaLifecycle("onDestroy()")
        super.onDestroy()
    }

    //Activity está na memória e passa a ser visível
    override fun onStart() {
        super.onStart()
        atualizaLifecycle("onStart()")
    }

    //Activity deixa de ser visível, mas ainda está na memória
    override fun onStop() {
        atualizaLifecycle("onStop()")
        super.onStop()
    }

    //Activity está na memória, visível, e vai ficar em FOREGROUND - primeiro plano
    override fun onResume() {
        super.onResume()
        atualizaLifecycle("onResume()")
    }

    //Activity está deixando de ficar em primeiro plano, mas ainda na memória e visível
    override fun onPause() {
        atualizaLifecycle("onPause()")
        super.onPause()
    }

    override fun onRestart() {
        super.onRestart()
        atualizaLifecycle("onRestart()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        //Bundle é um mapa chave -> valor
        outState.putString("oQueTemNoCampoDeTexto", binding.textoDigitado.text.toString())
        outState.putString("logLifecycle", binding.lifecycleLog.text.toString())
        super.onSaveInstanceState(outState)
    }


    //Extension function
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