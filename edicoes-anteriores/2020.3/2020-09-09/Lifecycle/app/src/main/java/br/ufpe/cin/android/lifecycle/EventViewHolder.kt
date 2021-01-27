package br.ufpe.cin.android.lifecycle

import android.text.format.DateUtils
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.linha.view.*

class EventViewHolder(linha: View, private val startTime: Long) : RecyclerView.ViewHolder(linha) {

    private val timestamp = linha.timestamp
    private val message = linha.message
    private val activityHash = linha.activityHash
    private val viewmodelHash = linha.viewmodelHash

    fun bindTo(event: Event) {
        val elapsedSeconds = (event.timestamp - startTime) / 1000
        timestamp.text = DateUtils.formatElapsedTime(elapsedSeconds)
        message.text = event.message
        activityHash.text = Integer.toHexString(event.activityHash)
        viewmodelHash.text = Integer.toHexString(event.viewmodelHash)
    }

}