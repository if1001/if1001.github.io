package br.ufpe.cin.android.datamgmt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPreferences.setOnClickListener {
            startActivity(Intent(this, PrefsActivity::class.java))
        }

        btnRoom.setOnClickListener {
            startActivity(Intent(this,RoomActivity::class.java))
        }

    }
}