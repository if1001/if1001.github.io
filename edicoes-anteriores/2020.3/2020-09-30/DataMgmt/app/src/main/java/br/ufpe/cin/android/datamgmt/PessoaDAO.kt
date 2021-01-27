package br.ufpe.cin.android.datamgmt

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PessoaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(pessoa:Pessoa)

    @Delete
    fun remover(vararg pessoa:Pessoa)

    @Query("SELECT * FROM pessoas")
    fun todasPessoas(): LiveData<List<Pessoa>>

    @Query("SELECT * FROM pessoas WHERE nome LIKE :argumento")
    fun buscarPeloNome(argumento:String):List<Pessoa>
}