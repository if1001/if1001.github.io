package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.ufpe.cin.android.datamanagement.databinding.ActivityAdicionarPessoaBinding

class AdicionarPessoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdicionarPessoaBinding
    private val viewModel: ProfessorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdicionarPessoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInserir.setOnClickListener {
            val _nome = binding.nome.text.toString()
            val _login = binding.login.text.toString()
            val _legal = binding.legal.isChecked
            val prof = Professor(nome=_nome, login=_login, legal=_legal)
            viewModel.inserir(prof)
            finish()
        }
    }

}