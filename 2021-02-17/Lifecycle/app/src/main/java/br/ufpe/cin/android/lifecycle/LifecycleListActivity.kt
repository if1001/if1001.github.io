package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpe.cin.android.lifecycle.databinding.ActivityLifecycleListBinding
import java.util.*

class LifecycleListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleListBinding
    private lateinit var eventAdapter: EventAdapter
    val events : MutableList<Event> = mutableListOf()
    val startTime = SystemClock.elapsedRealtime()
    private val id = Random().nextInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifecycleListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventAdapter = EventAdapter(layoutInflater, startTime)
        addEvent("onCreate()")

        binding.items.apply {
            layoutManager = LinearLayoutManager(this@LifecycleListActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@LifecycleListActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = eventAdapter
        }

    }

    private fun addEvent(message: String) {
        events.add(Event(message,id,id))
        eventAdapter.submitList(ArrayList(events))
    }

}