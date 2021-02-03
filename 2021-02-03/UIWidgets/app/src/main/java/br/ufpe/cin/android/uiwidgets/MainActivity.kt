package br.ufpe.cin.android.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import br.ufpe.cin.android.uiwidgets.databinding.ActivityMainBinding

//import android.widget.Button
//import android.widget.TextView
//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        //val botao = findViewById<Button>(R.id.botao)
        //val texto = findViewById<TextView>(R.id.texto)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val botao = binding.botao
        val texto = binding.texto
        val campoTexto = binding.campoTexto


        //onClick(View v)
        botao.setOnClickListener {
            val oQueFoiClicado = it

            val oQueFoiDigitado = campoTexto.text.toString()
            if (oQueFoiDigitado.isEmpty()){
                Log.d("UI WIDGETS", "Não digitou nada no campo de texto")
                Toast.makeText(
                    //this,
                    applicationContext,//Application
                    "Por favor, digite algo",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                texto.text = oQueFoiDigitado
                Log.d("UI WIDGETS", oQueFoiDigitado)

            }

        }


    }
}