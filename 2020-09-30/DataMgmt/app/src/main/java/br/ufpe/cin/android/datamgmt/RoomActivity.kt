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
    private val pessoaViewModel : PessoaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        val adapter = PessoaAdapter(this)

        rvPessoas.setHasFixedSize(true)
        rvPessoas.layoutManager = LinearLayoutManager(this)
        rvPessoas.adapter = adapter

        pessoaViewModel.todasPessoas.observe(
            this,
            Observer {
                pessoas ->
                    pessoas?.let {
                        adapter.setPessoas(it)
                    }
            }
        )

        btn_Adiciona.setOnClickListener {
            val intent = Intent(this, AdicionarPessoaActivity::class.java)
            startActivityForResult(intent, inserirPessoaRequestCode)
        }
        btn_Random.setOnClickListener {
            pessoaViewModel.inserir(Pessoa("Teste","tty"))
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)
        if (requestCode == inserirPessoaRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val nome = data.getStringExtra(AdicionarPessoaActivity.KEY_NOME)
                val login = data.getStringExtra(AdicionarPessoaActivity.KEY_LOGIN)
                if (nome!=null && login!=null){
                    val pessoa = Pessoa(nome, login)
                    pessoaViewModel.inserir(pessoa)
                }
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Erro ao adicionar pessoa, algum campo não foi preenchido.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}