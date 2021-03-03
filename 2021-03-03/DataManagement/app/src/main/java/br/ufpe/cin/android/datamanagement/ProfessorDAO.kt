package br.ufpe.cin.android.datamanagement

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProfessorDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(professor:Professor)

    @Update
    suspend fun atualizar(vararg professor: Professor)
    //atualizar(p1,p2,p3)

    @Delete
    suspend fun remover(vararg professor: Professor)

    @Query("SELECT * FROM professores ORDER BY nome ASC")
    fun todosProfessores() : LiveData<List<Professor>>

    @Query("SELECT * FROM professores WHERE nome LIKE :nome")
    suspend fun buscarPeloNome(nome:String) : List<Professor>

    @Query("SELECT * FROM professores WHERE login = :login")
    suspend fun buscarPeloLogin(login:String) : Professor
}