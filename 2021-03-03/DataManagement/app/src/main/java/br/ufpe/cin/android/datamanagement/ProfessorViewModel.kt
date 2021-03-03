package br.ufpe.cin.android.datamanagement

import android.util.Log
import androidx.lifecycle.ViewModel

class ProfessorViewModel : ViewModel() {
    private val repo : ProfessorRepository = ProfessorRepository()
    val professores = repo.professores

    fun inserir(professor: Professor) {
        repo.inserir(professor)
    }
}