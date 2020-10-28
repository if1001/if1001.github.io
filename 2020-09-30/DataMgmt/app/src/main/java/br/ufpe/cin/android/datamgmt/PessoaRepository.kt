package br.ufpe.cin.android.datamgmt

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class PessoaRepository(private val pessoaDAO: PessoaDAO) {
    val todasPessoas : LiveData<List<Pessoa>> = pessoaDAO.todasPessoas()

    @WorkerThread
    suspend fun inserir(pessoa: Pessoa) {
        pessoaDAO.inserir(pessoa)
    }
}