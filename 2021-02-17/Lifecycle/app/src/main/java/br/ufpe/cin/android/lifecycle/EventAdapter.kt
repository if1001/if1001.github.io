package br.ufpe.cin.android.lifecycle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import br.ufpe.cin.android.lifecycle.databinding.ItemBinding

class EventAdapter(
    private val inflater: LayoutInflater,
    private val startTime: Long
) : ListAdapter<Event, EventViewHolder>(EventDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemBinding.inflate(inflater, parent, false)
        return EventViewHolder(binding, startTime)
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