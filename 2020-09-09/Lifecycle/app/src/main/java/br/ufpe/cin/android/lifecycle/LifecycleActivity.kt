package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_lifecycle.*
import java.text.SimpleDateFormat
import java.util.*

class LifecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
    }

    private fun atualizaLifecycle(msg: String) {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        val toPrint = "$currentDate $msg"
        val m = lifecycleLog.text.toString()
        Log.d("LifecycleActivity",toPrint)
        lifecycleLog.text = "$toPrint\n$m"
    }

}
