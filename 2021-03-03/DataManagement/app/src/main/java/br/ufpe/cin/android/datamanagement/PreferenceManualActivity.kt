package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import br.ufpe.cin.android.datamanagement.databinding.ActivityPreferenceManualBinding

class PreferenceManualActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPreferenceManualBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceManualBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val username = preferences.getString(PreferenceScreenActivity.USERNAME,"")
        binding.editTextUsername.setText(username)

        binding.salvarUsername.setOnClickListener {
            val usernameDigitado = binding.editTextUsername.text.toString()
            preferences.edit {
                putString(PreferenceScreenActivity.USERNAME,usernameDigitado)
            }
            finish()
        }

    }
}