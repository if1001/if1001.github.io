package br.ufpe.cin.android.background

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.background.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnMainThread.setOnClickListener {
            startActivity(Intent(this,UIThreadActivity::class.java))
        }
        binding.btnThreads.setOnClickListener {
            startActivity(Intent(this,ThreadActivity::class.java))
        }
        binding.btnCoroutines.setOnClickListener {
            startActivity(Intent(this,CoroutinesActivity::class.java))
        }
        binding.btnCost.setOnClickListener {
            startActivity(Intent(this,CostActivity::class.java))
        }
        binding.btnCoroutinesViewModel.setOnClickListener {
            startActivity(Intent(this,CoroutinesViewModelActivity::class.java))
        }
    }
}