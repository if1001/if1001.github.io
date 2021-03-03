package br.ufpe.cin.android.datamanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.datamanagement.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSharedPreferences.setOnClickListener {
            startActivity(Intent(this,SharedPreferencesActivity::class.java))
        }
        binding.btnPreferenceDataStore.setOnClickListener {
            startActivity(Intent(this,PreferenceDataStoreActivity::class.java))
        }
        binding.btnPreferenceScreen.setOnClickListener {
            startActivity(Intent(this,PreferenceScreenActivity::class.java))
        }
        binding.btnRoom.setOnClickListener {
            startActivity(Intent(this,RoomActivity::class.java))
        }
    }
}