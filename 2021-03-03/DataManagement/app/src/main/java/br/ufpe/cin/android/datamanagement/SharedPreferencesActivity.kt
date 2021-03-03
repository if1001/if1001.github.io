package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.ufpe.cin.android.datamanagement.databinding.ActivityGameBinding

class SharedPreferencesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    private val viewModel: GameViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playButton.setOnClickListener {
            viewModel.jogar()
        }

        binding.resetButton.setOnClickListener {
            viewModel.resetarPontuacao()
        }

        viewModel.maiorPontuacao.observe(
            this,
            Observer { pontuacao ->
                val scoreAtual = pontuacao.toString()
                binding.highScoreText.text = scoreAtual
            }
        )

        viewModel.pontuacaoAtual.observe(
            this,
            Observer {
                binding.gameScoreText.text = it.toString()
            }
        )
    }
}