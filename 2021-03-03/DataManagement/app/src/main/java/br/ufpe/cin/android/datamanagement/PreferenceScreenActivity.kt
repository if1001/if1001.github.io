package br.ufpe.cin.android.datamanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.textoUsername.text = "não foi definido ainda"
    }
}