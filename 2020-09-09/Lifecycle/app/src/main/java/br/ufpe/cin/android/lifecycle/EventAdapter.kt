package br.ufpe.cin.android.lifecycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class EventAdapter(
    private val inflater: LayoutInflater,
    private val startTime: Long
) : ListAdapter<Event, EventViewHolder>(EventDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val linha = inflater.inflate(R.layout.linha,parent,false)
        return EventViewHolder(linha,startTime)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }

    private object EventDiffer : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean = oldItem == newItem


        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }

    }


}