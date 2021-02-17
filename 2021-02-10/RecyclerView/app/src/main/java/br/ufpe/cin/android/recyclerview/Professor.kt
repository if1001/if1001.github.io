package br.ufpe.cin.android.recyclerview
//POJO
data class Professor(val nome:String, val login:String) {
    val email: String = "$login@cin.ufpe.br"
    val site: String
    init{
        site = "https://www.cin.ufpe.br/~$login"
    }

    override fun toString(): String {
        return "Prof. $nome"
    }
}
/*
public class Pessoa {
    private String nome;
    private String login;
    public Pessoa(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }
    getNome/setNome
    getLogin/setLogin
}


 */