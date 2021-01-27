package br.ufpe.cin.android.lifecycle

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            //Exemplo de Intent Explícito
            //Estou explicitamente definindo qual Activity eu quero abrir
            val i = Intent(this,LifecycleActivity::class.java)
            startActivity(i)
        }

        btnLifecycleList.setOnClickListener {
            startActivity(Intent(this,LifecycleListActivity::class.java))
        }

        btn2.setOnClickListener {
            //Intent Implícito
            //Não estou fixando a activity que será aberta
            val i = Intent()
            i.action = ACTION_VIEW
            i.data = Uri.parse("http://www.cin.ufpe.br")
            i.addCategory(CATEGORY_DEFAULT)
            i.addCategory(CATEGORY_BROWSABLE)
            startActivity(i)
        }

        btn3.setOnClickListener {
            val i = Intent(ACTION_VIEW)
            i.data = Uri.parse("geo:0,0?q=Rua da Aurora")
            startActivity(i)
        }

        btn4.setOnClickListener {
        }

        btnImplicit.setOnClickListener {
        }

        btnExplicit.setOnClickListener {
        }
    }
}
