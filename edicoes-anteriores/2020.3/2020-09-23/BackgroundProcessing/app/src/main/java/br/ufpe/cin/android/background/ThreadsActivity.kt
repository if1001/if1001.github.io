package br.ufpe.cin.android.background

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_task.*
import java.net.URL


class ThreadsActivity : AppCompatActivity() {
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
            //new Thread(new Runnable(... public void run() { ...código a ser executado em uma worker thread... })
            Thread {
                //isso TEM que ser feito fora da Main Thread
                val conteudo = URL("https://www.cin.ufpe.br").readText()
                //isso não pode ser feito fora da Main Thread
                //resultadoOperacaoRede.text = conteudo

                runOnUiThread { resultadoOperacaoRede.text = conteudo }
            }.start()

        }

    }

    //Esta classe era uma forma (agora deprecated) de estruturar tarefas que devem rodar em background, mas depois atualizar UI
    //se quiser testar, inclua no onStart ou onResume o código -> Tarefa().execute("https://www.cin.ufpe.br")
    inner class Tarefa() : AsyncTask<String,Void,String>() {
        override fun onPreExecute() {
            //garantido de rodar na main/UI thread
            resultadoOperacao.text = "começando"
        }

        //vararg significa que podemos passar N strings (url1,url2,url3)
        override fun doInBackground(vararg params: String?): String {
            TODO("Not yet implemented")
            //garantido de rodar em uma thread de background
            val conteudo = URL(params[0]).readText()
            return conteudo
        }

        override fun onPostExecute(result: String?) {
            //garantido de rodar na main/UI thread
            resultadoOperacao.text = result
        }

    }

}