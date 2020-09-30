package br.ufpe.cin.android.datamgmt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PrefsMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Carrega um layout que contem um fragmento
        setContentView(R.layout.activity_prefs_menu)
            /*
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_container, UserPreferenceFragment())
            .commit()

             */
    }
}
