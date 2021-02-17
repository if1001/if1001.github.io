package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpe.cin.android.lifecycle.databinding.ActivityLifecycleListBinding
import java.util.*

class LifecycleListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleListBinding
    private lateinit var eventAdapter: EventAdapter

    //val events : MutableList<Event> = mutableListOf()
    //val startTime = SystemClock.elapsedRealtime()
    private val activityId = Random().nextInt()

    private val viewModel: EventViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifecycleListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventAdapter = EventAdapter(layoutInflater, viewModel.startTime)

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

    override fun onStart() {
        super.onStart()
        addEvent("onStart()")
    }

    override fun onResume() {
        super.onResume()
        addEvent("onResume()")
    }

    override fun onRestart() {
        super.onRestart()
        addEvent("onRestart()")
    }

    override fun onPause() {
        addEvent("onPause()")
        super.onPause()
    }

    override fun onStop() {
        addEvent("onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        addEvent("onDestroy()")
        super.onDestroy()
    }

    private fun addEvent(message: String) {
        viewModel.addEvent(message,activityId)
        eventAdapter.submitList(ArrayList(viewModel.events))
    }

}