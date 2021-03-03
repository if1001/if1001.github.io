package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.datamanagement.databinding.ActivityPreferenceManualBinding

class PreferenceManualActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPreferenceManualBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceManualBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.salvarUsername.setOnClickListener {
            val usernameDigitado = binding.editTextUsername.text.toString()

        }

    }
}