package br.ufpe.cin.android.broadcastreceivers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.broadcastreceivers.databinding.ActivityBateriaBinding

class BateriaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBateriaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBateriaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}