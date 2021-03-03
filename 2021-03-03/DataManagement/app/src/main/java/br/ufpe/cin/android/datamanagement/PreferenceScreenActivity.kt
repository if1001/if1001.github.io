package br.ufpe.cin.android.datamanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import br.ufpe.cin.android.datamanagement.databinding.ActivityPreferenceScreenBinding

class PreferenceScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreferenceScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnManual.setOnClickListener {
            startActivity(Intent(this,PreferenceManualActivity::class.java))
        }
        binding.btnPrefMenu.setOnClickListener {
            startActivity(Intent(this,PreferenceMenuActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val username = preferences.getString(PreferenceScreenActivity.USERNAME,"")
        binding.textoUsername.text = username
    }

    //public static final String USERNAME = "uname";
    companion object {
        //trocar para puxar de strings.xml a chave_username
        val USERNAME = "uname"
    }
}