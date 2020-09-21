package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lifecycle.*
import java.text.SimpleDateFormat
import java.util.*

class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        textoDigitado.text = savedInstanceState?.getString("oQueFoiDigitado")
        lifecycleLog.text = savedInstanceState?.getString("lifeCycleLog")

        atualizaLifecycle("onCreate()")

        botaoAdicionaTexto.setOnClickListener {
            val oQueFoiDigitado = campoTexto.text
            if (oQueFoiDigitado.isEmpty()) {
                toast("Digite algo, por favor")
            }
            else {
                textoDigitado.text = oQueFoiDigitado
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("oQueFoiDigitado",textoDigitado.text.toString())
        outState.putString("lifeCycleLog",lifecycleLog.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        atualizaLifecycle("onStart()")
    }

    override fun onResume() {
        super.onResume()
        atualizaLifecycle("onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        atualizaLifecycle("onRestart()")
    }

    override fun onPause() {
        atualizaLifecycle("onPause()")
        super.onPause()
    }

    override fun onStop() {
        atualizaLifecycle("onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        atualizaLifecycle("onDestroy()")
        // Não faça isso -> super.onCreate(null)
        super.onDestroy()
    }

    private fun atualizaLifecycle(msg: String) {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        val toPrint = "$currentDate $msg"
        val m = lifecycleLog.text.toString()
        Log.d("LifecycleActivity",toPrint)
        lifecycleLog.text = "$toPrint\n$m"
    }

    fun Any.toast(msg:String) {
        Toast.makeText(applicationContext,msg, Toast.LENGTH_SHORT).show()
    }

}
