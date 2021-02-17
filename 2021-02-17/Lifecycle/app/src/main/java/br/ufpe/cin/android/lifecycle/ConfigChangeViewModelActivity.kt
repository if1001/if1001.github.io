package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.lifecycle.databinding.ActivityConfigChangeBinding

class ConfigChangeViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfigChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}