package br.ufpe.cin.android.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.ufpe.cin.android.intents.databinding.ActivityTxtBinding

class TxtActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTxtBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTxtBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentUsadoParaAbrirActivity = intent
        val assuntoQueVeioNoExtra = intentUsadoParaAbrirActivity.getStringExtra(Intent.EXTRA_SUBJECT)
        val msgQueVeioNoExtra = intentUsadoParaAbrirActivity.getStringExtra(Intent.EXTRA_TEXT)
        //null aqui embaixo
        val valorQueNaoVeioNoExtra = intentUsadoParaAbrirActivity.getStringExtra("algum outro valor")

        val booleanoDoExtra = intentUsadoParaAbrirActivity.getBooleanExtra("nome da chave", true)

        if (assuntoQueVeioNoExtra == null) {
            binding.assunto.text = "valor padrão"
        }
        else {
            binding.assunto.text = assuntoQueVeioNoExtra
        }
        binding.texto.text = msgQueVeioNoExtra
        if (valorQueNaoVeioNoExtra == null) {
            Log.d("INTENTSAPP", "Tentou pegar um extra, mas não tinha nada.")
        }
    }
}