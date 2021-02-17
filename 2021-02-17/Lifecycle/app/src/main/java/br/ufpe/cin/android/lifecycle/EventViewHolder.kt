package br.ufpe.cin.android.lifecycle

import android.text.format.DateUtils
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.android.lifecycle.databinding.ItemBinding

class EventViewHolder(item: ItemBinding, private val startTime: Long) : RecyclerView.ViewHolder(item.root) {

    private val timestamp = item.timestamp
    private val message = item.message
    private val activityHash = item.activityHash
    private val viewmodelHash = item.viewmodelHash

    fun bindTo(event: Event) {
        val elapsedSeconds = (event.timestamp - startTime) / 1000
        timestamp.text = DateUtils.formatElapsedTime(elapsedSeconds)
        message.text = event.message
        activityHash.text = Integer.toHexString(event.activityHash)
        viewmodelHash.text = Integer.toHexString(event.viewmodelHash)
    }

}