package br.ufpe.cin.android.background

import android.util.Log

object Util {
    private const val TAG = "ThreadInformation"

    fun logThreadInfo(msg: String) {
        Log.i(TAG, "$msg | Thread Name: ${Thread.currentThread().name} | Thread ID: ${Thread.currentThread().id}")
    }
}