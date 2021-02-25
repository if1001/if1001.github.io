package br.ufpe.cin.android.intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufpe.cin.android.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExplicitIntent.setOnClickListener {
            val intent = Intent(
                    this,
                    //applicationContext,
                    OutraActivity::class.java
            )
            intent.putExtra("chave", "valor passado via intent, botão de cima")

            startActivity(intent)
        }

        binding.btnExplicitBaixo.setOnClickListener {
            startActivity(
                    Intent(
                            this,
                            //applicationContext,
                            OutraActivity::class.java
                    ).putExtra("chave", "valor passado via intent, botão de baixo")
            )
        }

        binding.btnImplicitWeb.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.cin.ufpe.br")
            i.addCategory(Intent.CATEGORY_DEFAULT)
            i.addCategory(Intent.CATEGORY_BROWSABLE)

            startActivity(i)
        }

        binding.btnImplicitMapa.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse("geo:0,0?q=Marco Zero")
            startActivity(i)
        }

        binding.btnExplicitSMS.setOnClickListener {
            val i = Intent(this, TxtActivity::class.java)
            i.putExtra(Intent.EXTRA_SUBJECT, binding.assunto.text.toString())
            i.putExtra(Intent.EXTRA_TEXT, binding.msg.text.toString())
            startActivity(i)
        }

        binding.btnImplicitSMS.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"//MIME type, pode ser algo como image/jpeg
            i.putExtra(Intent.EXTRA_SUBJECT, binding.assunto.text.toString())
            i.putExtra(Intent.EXTRA_TEXT, binding.msg.text.toString())
            if (i.resolveActivity(packageManager) != null) {
                startActivity(i)
            }
            else {
                Toast.makeText(this,"Nenhum app resolve",Toast.LENGTH_SHORT).show()
            }
        }
    }
}