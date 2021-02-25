package br.ufpe.cin.android.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class OutraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        val msg = intent.getStringExtra("chave")//o tipo de retorno é String? ao invés de String
        //String? significa que msg pode ser nulo
        if (msg != null) {
            Log.d("INTENTSAPP", msg)
        }
    }
}