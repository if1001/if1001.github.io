package br.ufpe.cin.android.lifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.lifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConfigChange.setOnClickListener {
            //Exemplo de Intent Explícito
            //Estou explicitamente definindo qual Activity eu quero abrir
            val i = Intent(this,ConfigChangeActivity::class.java)
            startActivity(i)
        }

        binding.btnLifecycle.setOnClickListener {
            startActivity(Intent(this,LifecycleActivity::class.java))
        }

        binding.btnViewModel.setOnClickListener {
            startActivity(Intent(this,ConfigChangeViewModelActivity::class.java))
        }

        binding.btnLifecycleList.setOnClickListener {
            startActivity(Intent(this,LifecycleListActivity::class.java))
        }

    }
}