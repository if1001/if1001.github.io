package br.ufpe.cin.android.recyclerview

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import br.ufpe.cin.android.recyclerview.databinding.LinhaBinding

class ProfessorViewHolder(private val binding: LinhaBinding) :
    RecyclerView.ViewHolder(binding.root)
{
    var nome : String = "algum nome"
    var login : String = "algum login"
    var site : String = ""

    init {
        binding.root.setOnClickListener {
            val c = binding.nome.context

            //Intent Explicito
            val intentExplicito = Intent(c, ProfessorActivity::class.java)
            intentExplicito.putExtra("nome", nome)
            intentExplicito.putExtra("login", login)
            //c.startActivity(intentExplicito)

            val intentImplicito = Intent()
            intentImplicito.action = Intent.ACTION_VIEW
            intentImplicito.data = Uri.parse(site)//https://

            //intentImplicito.data = Uri.parse("geo:0,0?q=Marco Zero")

            c.startActivity(intentImplicito)
        }
    }
    fun bindTo(professor : Professor) {
        nome = professor.nome
        login = professor.login
        site = professor.site

        binding.nome.text = professor.nome
        binding.login.text= professor.login
        if (professor.login == "lmt") {
            binding.icone.setImageResource(R.drawable.ok)
        }
        else {
            binding.icone.setImageResource(R.drawable.delete)
        }
    }
}