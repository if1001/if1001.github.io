package br.ufpe.cin.android.datamanagement

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProfessorRepository {
    val listaProfessores = ArrayList<Professor>()
    val _professores = MutableLiveData<List<Professor>>()
    val professores : LiveData<List<Professor>> = _professores

    fun inserir(professor: Professor) {
        listaProfessores.add(professor)
        _professores.value = listaProfessores
    }
}