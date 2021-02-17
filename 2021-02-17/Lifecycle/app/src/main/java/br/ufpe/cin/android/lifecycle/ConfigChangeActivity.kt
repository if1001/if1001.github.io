package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.lifecycle.databinding.ActivityConfigChangeBinding

class ConfigChangeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfigChangeBinding
    private var clicks : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}