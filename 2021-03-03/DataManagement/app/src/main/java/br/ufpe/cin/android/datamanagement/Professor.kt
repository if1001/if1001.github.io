package br.ufpe.cin.android.datamanagement

data class Professor(
    var nome: String,
    val login: String,
    val site: String = "http://www.cin.ufpe.br/~$login",
    val email: String = "$login@cin.ufpe.br",
    val legal: Boolean = false
) {
    override fun toString(): String {
        return nome
    }
}