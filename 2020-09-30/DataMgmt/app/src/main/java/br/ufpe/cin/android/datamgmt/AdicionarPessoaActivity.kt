package br.ufpe.cin.android.datamgmt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_adicionar_pessoa.*

class AdicionarPessoaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_pessoa)

        btnInserir.setOnClickListener {
            val resposta = Intent()
            if (TextUtils.isEmpty(nome.text) || TextUtils.isEmpty(login.text)) {
                setResult(Activity.RESULT_CANCELED, resposta)
            } else {
                val nome = nome.text.toString()
                val login = login.text.toString()
                resposta.putExtra(KEY_NOME, nome)
                resposta.putExtra(KEY_LOGIN, login)
                setResult(Activity.RESULT_OK, resposta)
            }
            finish()
        }
    }

    companion object {
        const val KEY_NOME = "br.ufpe.cin.android.datamgmt.NOME"
        const val KEY_LOGIN = "br.ufpe.cin.android.datamgmt.LOGIN"
    }
}