package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import br.ufpe.cin.android.background.databinding.ActivityTaskBinding
import java.net.URL

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding

    var toasts = 0
    val limite = 1000

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
            operacaoLonga()
        }

        binding.btnNetwork.setOnClickListener {
            logThread("Callback do Botão Network")
            operacaoRede("https://www.cin.ufpe.br")
        }
    }

    private fun operacaoLonga() {
        /*
        Thread(object : Runnable() {
            override fun run() {
                var numPassos = 0
                for(i in 0 until limite) {
                    for (j in 0 until limite) {
                        for (k in 0 until limite) {
                            numPassos++
                        }
                    }
                }
                binding.statusOperacao.text = getString(R.string.terminouOperacao,numPassos)
            }
        }).start()
         */

        var numPassos = 0

        Thread {
            logThread("iniciando operação longa")
            for(i in 0 until limite) {
                for (j in 0 until limite) {
                    for (k in 0 until limite) {
                        numPassos++
                    }
                }
            }
            //o que está aqui só roda após o código do laço terminar
            /*
            Handler(Looper.getMainLooper()).post(object:Runnable {
                override fun run() {
                    binding.statusOperacao.text = getString(R.string.terminouOperacao,numPassos)
                }
            })
            */
            Handler(Looper.getMainLooper()).post {
                logThread("terminou, vamos atualizar o TextView")
                binding.statusOperacao.text = getString(R.string.terminouOperacao,numPassos)
            }
        }.start()



    }

    private fun operacaoRede(url: String) {
        logThread("iniciando método com a operação de rede")
        //pega o conteúdo do HTML e salva numa String
        //se o HTML for maior que 2 Gb não vai funcionar... :)

        //Isso aqui resulta em android.os.NetworkOnMainThreadException
        Thread {
            logThread("iniciando operação de rede")
            val conteudo = URL(url).readText()
            logThread("terminou operação de rede")
            runOnUiThread {
                logThread("atualizando status da operação de rede")
                binding.resultadoOperacaoRede.text = conteudo
            }
        }.start()

        logThread("quando isso vai rodar?")

    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }

}