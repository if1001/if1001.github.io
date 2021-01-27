package br.ufpe.cin.android.background

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainThread.setOnClickListener {
            startActivity(Intent(this,MainThreadActivity::class.java))
        }
        btnThreads.setOnClickListener {
            startActivity(Intent(this,ThreadsActivity::class.java))
        }
        btnCoroutines.setOnClickListener {
            startActivity(Intent(this,CoroutinesActivity::class.java))
        }
    }
}