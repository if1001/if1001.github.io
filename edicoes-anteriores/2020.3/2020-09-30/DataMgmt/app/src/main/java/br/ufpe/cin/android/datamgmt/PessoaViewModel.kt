package br.ufpe.cin.android.datamgmt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PessoaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : PessoaRepository
    val todasPessoas : LiveData<List<Pessoa>>
    init {
        val pessoasDAO = PessoaDB.getDatabase(application).pessoaDAO()
        repository = PessoaRepository(pessoasDAO)
        todasPessoas = repository.todasPessoas
    }

    fun inserir(pessoa:Pessoa) {
        //usando coroutines para inserir no BD fora da main thread
        viewModelScope.launch(Dispatchers.IO) {
            repository.inserir(pessoa)
        }
    }
}