package br.ufpe.cin.android.datamgmt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_prefs_edit.*

class PrefsEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs_edit)



        salvarUsername.setOnClickListener {

        }
    }
}