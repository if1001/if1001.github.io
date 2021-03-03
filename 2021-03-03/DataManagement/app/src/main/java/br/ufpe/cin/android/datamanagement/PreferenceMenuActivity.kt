package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class PreferenceMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference_menu)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.settings_container,UsernamePreferenceFragment())
            .commit()
    }

    class UsernamePreferenceFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            addPreferencesFromResource(R.xml.preferences)
        }
    }
}