package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufpe.cin.android.background.databinding.ActivityTaskBinding
import java.net.URL

class UIThreadActivity : AppCompatActivity() {
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

    private fun operacaoRede(url: String) {
        logThread("iniciando operação de rede")
        //pega o conteúdo do HTML e salva numa String
        //se o HTML for maior que 2 Gb não vai funcionar... :)

        //Isso aqui resulta em android.os.NetworkOnMainThreadException
        val conteudo = URL(url).readText()
        binding.resultadoOperacaoRede.text = conteudo
    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }
}