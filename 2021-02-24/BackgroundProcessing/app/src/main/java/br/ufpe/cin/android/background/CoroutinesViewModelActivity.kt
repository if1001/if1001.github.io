package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.background.databinding.ActivityViewmodelBinding

class CoroutinesViewModelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewmodelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewmodelBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }
}