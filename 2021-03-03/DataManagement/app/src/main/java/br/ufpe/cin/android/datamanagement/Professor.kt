package br.ufpe.cin.android.datamanagement

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "professores")
data class Professor(
    var nome: String,
    @PrimaryKey
    val login: String,
    val site: String = "http://www.cin.ufpe.br/~$login",
    val email: String = "$login@cin.ufpe.br",
    val legal: Boolean = false
) {
    override fun toString(): String {
        return nome
    }
}