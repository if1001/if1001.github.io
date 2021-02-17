package br.ufpe.cin.android.lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClickViewModel : ViewModel() {
    var clicks = 0

    val totalClicks : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun incrementClicks() {
        clicks++
        totalClicks.postValue(clicks)
    }
}