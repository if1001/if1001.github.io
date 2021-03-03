package br.ufpe.cin.android.datamanagement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel(val repository: GameRepository) : ViewModel() {
    private val range = 1000

    val maiorPontuacao : LiveData<Int> = repository.maiorPontuacao

    private val _pontuacaoAtual = MutableLiveData<Int>(0)
    val pontuacaoAtual : LiveData<Int> = _pontuacaoAtual



    fun jogar() {
        val numeroAleatorio = Random.nextInt(range)
        _pontuacaoAtual.value = numeroAleatorio
        val highScoreAtual = maiorPontuacao.value
        if (highScoreAtual!=null) {
            if (numeroAleatorio > highScoreAtual) {
                repository.persistirPontuacao(numeroAleatorio)
            }
        }
    }

    fun resetarPontuacao() {
        _pontuacaoAtual.value = 0
        repository.persistirPontuacao(0)
    }
}