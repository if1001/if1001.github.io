package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.datamanagement.databinding.ActivityGameBinding

class PreferenceDataStoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //TODO won't have time to cover during class
    }
}