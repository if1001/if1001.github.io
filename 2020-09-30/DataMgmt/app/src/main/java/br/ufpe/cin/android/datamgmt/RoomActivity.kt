package br.ufpe.cin.android.datamgmt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {

    private val inserirPessoaRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val adapter = PessoaAdapter(this, emptyList())

        rvPessoas.setHasFixedSize(true)
        rvPessoas.layoutManager = LinearLayoutManager(this)
        rvPessoas.adapter = adapter

        btn_Adiciona.setOnClickListener {
            val intent = Intent(this, AdicionarPessoaActivity::class.java)
            startActivityForResult(intent, inserirPessoaRequestCode)
        }

    }
}