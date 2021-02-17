package br.ufpe.cin.android.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.ufpe.cin.android.lifecycle.databinding.ActivityConfigChangeBinding

class ConfigChangeViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfigChangeBinding

    val viewModel : ClickViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {
            viewModel.incrementClicks()
        }

        //data binding
        viewModel.totalClicks.observe(
            this,
            Observer {
                binding.countClicks.text = it.toString()
            }
        )


    }
}