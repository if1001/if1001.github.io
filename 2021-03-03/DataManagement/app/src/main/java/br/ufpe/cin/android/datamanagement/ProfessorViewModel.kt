package br.ufpe.cin.android.datamanagement

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfessorViewModel(application: Application) : AndroidViewModel(application) {

    private val repo : ProfessorRepository = ProfessorRepository(
        ProfessorDB.getInstance(application).professorDAO()
    )
    val professores = repo.professores

    val professor = MutableLiveData<Professor>()

    fun inserir(professor: Professor) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.inserir(professor)
        }
    }

    fun atualizar(professor: Professor) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.atualizar(professor)
        }
    }

    fun remover(professor: Professor) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.remover(professor)
        }
    }

    fun buscarProfessorPeloLogin(login:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val prof = repo.buscarPeloLogin(login)
            // Fazer isto em background lança uma exceção professor.value = prof
            withContext(Dispatchers.Main.immediate) {
                professor.value = prof
            }
        }
    }
}