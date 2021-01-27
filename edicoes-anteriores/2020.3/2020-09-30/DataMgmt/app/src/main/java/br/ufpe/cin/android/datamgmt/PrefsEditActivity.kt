package br.ufpe.cin.android.datamgmt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_prefs_edit.*

class PrefsEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prefs_edit)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        val username = prefs.getString(PrefsActivity.USERNAME,"")
        editTextUsername.setText(username)

        salvarUsername.setOnClickListener {
            val oQueFoiDigitado = editTextUsername.text.toString()
            val editor = prefs.edit()
            editor.putString(PrefsActivity.USERNAME,oQueFoiDigitado)
            editor.commit()
            finish()
        }
    }
}