package br.ufpe.cin.android.datamanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.ufpe.cin.android.datamanagement.databinding.ActivityRoomBinding
import kotlin.random.Random

class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding

    private val viewModel : ProfessorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val professorAdapter = ProfessorAdapter(layoutInflater)

        binding.rvPessoas.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = professorAdapter
        }

        binding.btnAdiciona.setOnClickListener {
            //val i = Random.nextInt(Constants.maisProfessores.size)
            //val p = Constants.maisProfessores[i]
            //viewModel.inserir(p)
            startActivity(Intent(this, AdicionarPessoaActivity::class.java))
        }

        viewModel.professores.observe(
            this,
            Observer { listaProfessores ->
                professorAdapter.submitList(listaProfessores.toList())
            }
        )
    }
}