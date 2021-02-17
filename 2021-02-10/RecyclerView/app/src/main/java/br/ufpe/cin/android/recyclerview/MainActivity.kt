package br.ufpe.cin.android.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpe.cin.android.recyclerview.databinding.ActivityMainBinding

//Adapter-based

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewPessoas = binding.listaElementos

        //LayoutManager - como os elementos vão ser organizados
        //recyclerViewPessoas.layoutManager = LinearLayoutManager(this)
        //Item decorator - linhas horizontais entre os elementos, separando-os
        //recyclerViewPessoas.addItemDecoration(
        //        DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        //)
        //Adapter é o objeto que pega um elemento de uma coleção e renderiza na tela
        //recyclerViewPessoas.adapter = ProfessorAdapter(
        //    Constants.maisProfessores,
        //    layoutInflater
        //)

        recyclerViewPessoas.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            adapter = ProfessorAdapter(Constants.maisProfessores,layoutInflater)
        }

        //animator - efeitos animados na medida que os dados mudam
    }
}