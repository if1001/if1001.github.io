package br.ufpe.cin.android.datamgmt

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoas")
data class Pessoa(
    var nome: String,
    @PrimaryKey
    val login: String,
    val site: String = "http://www.cin.ufpe.br/~$login",
    val email: String = "$login@cin.ufpe.br"
) {
    override fun toString(): String {
        return nome
    }
}