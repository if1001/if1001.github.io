package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import br.ufpe.cin.android.background.databinding.ActivityTaskBinding
import kotlinx.coroutines.*
import java.net.URL

class CoroutinesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    var toasts = 0
    val limite = 1000

    private var jobNetwork : Job? = null
    private var jobLongOperation : Job? = null


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
            jobLongOperation = coroutineScope.launch {
                binding.btnLongOperation.isEnabled = false
                logThread("antes da chamada ao método operacaoLonga()")
                binding.statusOperacao.text = getString(R.string.comecouOperacao)
                val numPassos = operacaoLonga()
                logThread("após chamada ao método operacaoLonga()")
                logThread("terminou, vamos atualizar o TextView")
                binding.statusOperacao.text = getString(R.string.terminouOperacao,numPassos)
                binding.btnLongOperation.isEnabled = true
            }
        }

        binding.btnNetwork.setOnClickListener {
            logThread("Callback do Botão Network")
            jobNetwork = coroutineScope.launch {
                binding.btnNetwork.isEnabled = false
                val conteudo = operacaoRede("https://www.cin.ufpe.br")
                //val conteudo = operacaoRedeAssumindoBackgroundThread("https://www.cin.ufpe.br")
                logThread("terminou operacaoRede()")
                binding.resultadoOperacaoRede.text = conteudo
                binding.btnNetwork.isEnabled = true
            }

        }
    }

    override fun onStop() {
        //jobNetwork?.cancel()
        //jobLongOperation?.cancel()
        //essa linha abaixo é equivalente a usar as duas acima
        coroutineScope.coroutineContext.cancelChildren()
        binding.btnLongOperation.isEnabled = true
        binding.btnNetwork.isEnabled = true
        super.onStop()
    }

    private suspend fun operacaoLonga() : Int = withContext(Dispatchers.Default) {
            var numPassos = 0
            logThread("iniciando operação longa")
            for(i in 0 until limite) {
                for (j in 0 until limite) {
                    for (k in 0 until limite) {
                        numPassos++
                    }
                }
            }
            numPassos
        }


    private suspend fun operacaoRede(url: String) : String {
        return withContext(Dispatchers.IO) {
            logThread("iniciando operação de rede")
            val conteudo = URL(url).readText()
            logThread("terminou operação de rede")
            conteudo
        }
    }


    private suspend fun operacaoRedeAssumindoBackgroundThread(url: String) : String {
        logThread("iniciando operação de rede")
        val conteudo = URL(url).readText()
        logThread("terminou operação de rede")
        return conteudo
    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }

}