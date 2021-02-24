package br.ufpe.cin.android.background

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesViewModel : ViewModel() {
    private val _toasts = MutableLiveData<Int>(0)
    val toasts : LiveData<Int> = _toasts

    private val _quantoTempoPassou = MutableLiveData<Int>(0)
    val quantoTempoPassou : LiveData<Int> = _quantoTempoPassou

    private val _estaContandoTempo = MutableLiveData<Boolean>(false)
    val estaContandoTempo : LiveData<Boolean> = _estaContandoTempo

    private val limite = 500

    fun incrementaToasts() {
        _toasts.postValue(toasts.value?.plus(1))
    }

    fun iniciaOuParaContagem() {
        val estaContandoTempoAgora = estaContandoTempo.value
        Util.logThreadInfo("iniciaOuParaContagem() | estaContandoTempoAgora = $estaContandoTempoAgora")
        if (estaContandoTempoAgora == null || !estaContandoTempoAgora) {
            iniciarContagem()
        }
        else {
            pararContagem()
        }
    }

    private fun iniciarContagem() = viewModelScope.launch {
        Util.logThreadInfo("iniciarContagem()")
        var segundos = 0
        _estaContandoTempo.postValue(true)
        while(true) {
            val msg = "$segundos segundos"
            Util.logThreadInfo(msg)
            _quantoTempoPassou.postValue(segundos)
            delay(1000)
            segundos++
        }
    }

    private fun pararContagem() {
        Util.logThreadInfo("pararContagem()")
        _estaContandoTempo.postValue(false)
        viewModelScope.coroutineContext.cancelChildren()
    }

}