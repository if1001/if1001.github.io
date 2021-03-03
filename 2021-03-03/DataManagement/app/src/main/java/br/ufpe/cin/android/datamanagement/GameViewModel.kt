package br.ufpe.cin.android.datamanagement

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private val range = 1000

    private val _maiorPontuacao = MutableLiveData<Int>(0)
    val maiorPontuacao : LiveData<Int> = _maiorPontuacao

    fun jogar() {
        val numeroAleatorio = Random.nextInt(range)
        val highScoreAtual = maiorPontuacao.value
        if (highScoreAtual!=null) {
            if (numeroAleatorio > highScoreAtual) {
                _maiorPontuacao.postValue(numeroAleatorio)
            }
        }
    }

    fun resetarPontuacao() {
        _maiorPontuacao.postValue(0)
    }
}