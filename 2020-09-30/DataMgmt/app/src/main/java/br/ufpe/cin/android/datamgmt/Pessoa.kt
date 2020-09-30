package br.ufpe.cin.android.datamgmt

data class Pessoa(
    var nome: String,
    val login: String,
    val site: String = "http://www.cin.ufpe.br/~$login",
    val email: String = "$login@cin.ufpe.br"
) {
    override fun toString(): String {
        return nome
    }
}