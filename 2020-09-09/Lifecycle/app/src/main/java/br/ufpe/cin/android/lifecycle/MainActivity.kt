package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
        }

        btn2.setOnClickListener {
        }

        btn3.setOnClickListener {
        }

        btn4.setOnClickListener {
        }

        btnImplicit.setOnClickListener {
        }

        btnExplicit.setOnClickListener {
        }
    }
}
