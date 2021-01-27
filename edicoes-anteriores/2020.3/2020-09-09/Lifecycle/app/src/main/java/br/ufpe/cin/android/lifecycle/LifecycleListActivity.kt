package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lifecycle_list.*
import java.util.*

class LifecycleListActivity : AppCompatActivity() {
    private lateinit var adapter : EventAdapter
    private val viewModel : EventViewModel by viewModels()
    private val id = Random().nextInt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle_list)

        adapter = EventAdapter(layoutInflater, viewModel.startTime)
        addEvent("onCreate()")

        items.layoutManager = LinearLayoutManager(this)
        items.addItemDecoration(
            DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        )
        items.adapter = adapter

    }
    override fun onStart() {
        super.onStart()
        addEvent("onStart()")
    }
    override fun onResume() {
        super.onResume()
        addEvent("onResume()")
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



    private fun addEvent(message:String) {
        viewModel.addEvent(message,id)
        adapter.submitList(ArrayList(viewModel.events))
    }
}