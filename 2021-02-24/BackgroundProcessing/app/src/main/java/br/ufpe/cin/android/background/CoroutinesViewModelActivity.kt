package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.ufpe.cin.android.background.databinding.ActivityViewmodelBinding

class CoroutinesViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewmodelBinding

    private val viewModel: CoroutinesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewmodelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contadorToasts.text = getString(R.string.contadorToasts, viewModel.toasts.value)

        binding.btnToast.setOnClickListener {
            logThread("Callback do Botão do Toast")
            viewModel.incrementaToasts()
        }

        viewModel.toasts.observe(
            this,
            Observer { numToasts ->
                binding.contadorToasts.text = getString(R.string.contadorToasts, numToasts)
            }
        )

        binding.btnLongOperation.setOnClickListener {
            logThread("Callback do Botão Inicia Contador de Tempo Operation")
            viewModel.iniciaOuParaContagem()
        }

        viewModel.estaContandoTempo.observe(
            this,
            Observer { estaContandoTempoAgora ->
                binding.btnLongOperation.text = if (estaContandoTempoAgora) {
                    "Parar contagem"
                } else {
                    "Iniciar contagem"
                }
            }
        )

        viewModel.quantoTempoPassou.observe(
            this,
            Observer {
                binding.statusOperacao.text = "$it segundos"
            }
        )
    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }
}