package br.ufpe.cin.android.datamgmt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_adicionar_pessoa.*

class AdicionarPessoaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_pessoa)

        btnInserir.setOnClickListener {

        }
    }

    companion object {
        const val KEY_NOME = "br.ufpe.cin.android.datamgmt.NOME"
        const val KEY_LOGIN = "br.ufpe.cin.android.datamgmt.LOGIN"
    }
}