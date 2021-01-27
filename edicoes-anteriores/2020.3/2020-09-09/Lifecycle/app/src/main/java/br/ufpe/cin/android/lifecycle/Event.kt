package br.ufpe.cin.android.lifecycle

import android.os.SystemClock

data class Event(
    val message: String,
    val activityHash: Int,
    val viewmodelHash: Int,
    val timestamp: Long = SystemClock.elapsedRealtime()
)