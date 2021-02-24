package br.ufpe.cin.android.background

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufpe.cin.android.background.databinding.ActivityCostBinding
import kotlinx.coroutines.*

class CostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCostBinding

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCoroutines.setOnClickListener {
            for (i in 1..100) {
                coroutineScope.launch {
                    logThread("Executado antes do delay - $i")
                    aguardar(i)
                    logThread("Executado após delay - $i")
                }
            }
        }

        binding.btnThreads.setOnClickListener {
            for (i in 1..100) {
                Thread {
                    logThread("Executado antes do delay - $i")
                    Thread.sleep(2000)
                    logThread("Executado após delay - $i")
                }.start()
            }
        }
    }
    private suspend fun aguardar(i:Int) {
        withContext(Dispatchers.Default) {
            logThread("antes do delay - $i")
            delay(2000)
        }
    }

    private fun logThread(msg: String) {
        Util.logThreadInfo(msg)
    }
}