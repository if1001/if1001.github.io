package br.ufpe.cin.android.datamanagement

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProfessorRepository(private val dao: ProfessorDAO) {
    val professores = dao.todosProfessores()

    @WorkerThread
    suspend fun inserir(professor: Professor) {
        dao.inserir(professor)
    }

    @WorkerThread
    suspend fun atualizar(professor: Professor) {
        dao.atualizar(professor)
    }

    @WorkerThread
    suspend fun remover(professor: Professor) {
        dao.remover(professor)
    }

    @WorkerThread
    suspend fun buscarPeloLogin(login: String) : Professor {
        return dao.buscarPeloLogin(login)
    }
}