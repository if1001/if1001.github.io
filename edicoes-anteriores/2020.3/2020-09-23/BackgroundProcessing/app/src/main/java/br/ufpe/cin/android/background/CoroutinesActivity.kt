package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_task.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL

class CoroutinesActivity : AppCompatActivity() {
    var toasts = 0
    //Aumentar demais pode causar ANR
    val bound = 1000

    //Faz parte do Ciclo de Vida da Activity - Rodam na Main Thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        contadorToasts.text = getString(R.string.contadorToasts,toasts)

        btnToast.setOnClickListener {
            toasts++
            val msg = getString(R.string.contadorToasts,toasts)
            Toast.makeText(
                this,
                msg,
                Toast.LENGTH_SHORT
            ).show()
            contadorToasts.text = msg
        }

        //tente alterar o código para usar coroutines
        btnLongOperation.setOnClickListener {
            var num = 0
            resultadoOperacao.text = getString(R.string.comecouOperacao)
            Thread {
                for (i in 0 until bound) {
                    for (j in 0 until bound) {
                        for (k in 0 until bound) {
                            //fazer alguma operação mais longa e complexa aqui
                            num++
                            //Log.d("MAIN_THREAD","Passo número $num")
                        }
                    }
                }
                runOnUiThread {
                    resultadoOperacao.text = getString(R.string.terminouOperacao,num)
                }
            }.start()

        }

        btnNetwork.setOnClickListener {
            //não estou definindo que está sendo criada uma nova thread, necessariamente
            //estou apenas sinalizando o DISPATCHER onde o código vai rodar
            GlobalScope.launch(Dispatchers.IO) {
                doNetworkUpdateUI("https://www.cin.ufpe.br")
            }
        }
    }

    suspend fun doNetworkUpdateUI(url:String) {
        val conteudo = getTextFromURL(url)
        GlobalScope.launch(Dispatchers.Main) {
            resultadoOperacaoRede.text = conteudo
        }
    }

    suspend fun getTextFromURL(url:String) :String {
        return URL(url).readText()
    }

}