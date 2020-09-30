package br.ufpe.cin.android.datamgmt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_prefs.*

class PrefsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs)

        edit_pref_button.setOnClickListener {
            startActivity(
                Intent(
                    this@PrefsActivity,
                    PrefsEditActivity::class.java)
            )
        }
        check_pref_button.setOnClickListener {
            startActivity(
                Intent(
                    this@PrefsActivity,
                    PrefsMenuActivity::class.java)
            )
        }
    }

    override fun onResume() {
        super.onResume()
    }

    companion object {
        val USERNAME = "uname"
    }
}