package br.ufpe.cin.android.lifecycle

import android.os.SystemClock
import androidx.lifecycle.ViewModel
import java.util.*

class EventViewModel : ViewModel() {
    val events : MutableList<Event> = mutableListOf()
    val startTime = SystemClock.elapsedRealtime()
    private val viewModelId = Random().nextInt()

    fun addEvent(message: String, activityId:Int) {
        events.add(Event(message,activityId,viewModelId))
    }

    override fun onCleared() {
        events.clear()
        super.onCleared()
    }

}