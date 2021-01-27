package br.ufpe.cin.android.lifecycle

import android.os.SystemClock
import androidx.lifecycle.ViewModel
import java.util.*

class EventViewModel : ViewModel() {
    val events : MutableList<Event> = mutableListOf()
    val startTime = SystemClock.elapsedRealtime()
    private val id = Random().nextInt()

    fun addEvent(message:String, activityHash:Int) {
        events.add(Event(message,activityHash,id))
    }

    override fun onCleared() {
        events.clear()
    }
}