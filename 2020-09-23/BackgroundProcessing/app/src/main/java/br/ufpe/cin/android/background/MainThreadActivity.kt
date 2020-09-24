package br.ufpe.cin.android.background

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task.*
import java.net.URL

class MainThreadActivity : AppCompatActivity() {

    var toasts = 0
    //Aumentar demais pode causar ANR
    val bound = 1000

    //Faz parte do Ciclo de Vida da Activity - Rodam na Main Thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        contadorToasts.text = getString(R.string.contadorToasts,toasts)
        //contadorToasts.setText("zero toasts gerados")
        //equivalente a contadorToasts.setText("zero..")
        //essa chamada a setText vai para uma fila de mensagens
        //essa fila é processada por uma thread, normalmente chamada de MainThread ou UI Thread
        // a lentidão durante o uso da UI é chamada de Jank normalmente

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

        btnLongOperation.setOnClickListener {
            var num = 0
            resultadoOperacao.text = getString(R.string.comecouOperacao)
            for (i in 0 until bound) {
                for (j in 0 until bound) {
                    for (k in 0 until bound) {
                        //fazer alguma operação mais longa e complexa aqui
                        num++
                        //Log.d("MAIN_THREAD","Passo número $num")
                    }
                }
            }
            resultadoOperacao.text = getString(R.string.terminouOperacao,num)
        }

        btnNetwork.setOnClickListener {
            //readText() -> No máximo 2Gb
            //Pegando o conteúdo do HTML em uma String
            //Resulta em uma NetworkOnMainThreadException
            val conteudo = URL("https://www.cin.ufpe.br").readText()
            resultadoOperacaoRede.text = conteudo
        }


    }
}