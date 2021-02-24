package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.background.databinding.ActivityCostBinding

class CostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCoroutines.setOnClickListener {

        }

        binding.btnThreads.setOnClickListener {

        }
    }

}