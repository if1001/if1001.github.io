package br.ufpe.cin.android.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botao.setOnClickListener(View.OnClickListener {

        })
        botao.setOnClickListener {
            val b = it as Button
            Log.d("AULA",b.text.toString())
            val oQueFoiDigitado = campoDeTexto.text
            textoExibido.text = oQueFoiDigitado
        }


    }
}
