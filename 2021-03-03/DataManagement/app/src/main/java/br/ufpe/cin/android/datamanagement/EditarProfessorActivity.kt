package br.ufpe.cin.android.datamanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import br.ufpe.cin.android.datamanagement.databinding.ActivityEditarProfessorBinding

class EditarProfessorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditarProfessorBinding
    private val viewModel: ProfessorViewModel by viewModels()
    private lateinit var professor : Professor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarProfessorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login = intent.getStringExtra("login")
        if (login!=null) {
            viewModel.buscarProfessorPeloLogin(login)
        }
        else {
            Toast.makeText(this,"Houve algum erro",Toast.LENGTH_SHORT).show()
            finish()
        }

        viewModel.professor.observe(
            this,
            Observer {
                binding.nome.setText(it.nome)
                binding.login.setText(it.nome)
                binding.login.isEnabled = false
                binding.legal.isChecked = it.legal
                professor = it
            }
        )

        binding.btnAtualizar.setOnClickListener {
            val _nome = binding.nome.text.toString()
            val _login = binding.login.text.toString()
            val _legal = binding.legal.isChecked
            val prof = Professor(nome=_nome, login=_login, legal=_legal)
            viewModel.atualizar(prof)
            finish()
        }
        binding.btnRemover.setOnClickListener {
            if (professor!=null) {
                viewModel.remover(professor)
            }
            else {
                Toast.makeText(this,"Houve algum erro",Toast.LENGTH_SHORT).show()
            }
            finish()
        }


    }
}