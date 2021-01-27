package br.ufpe.cin.android.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start_act_result.*

class StartActResultActivity : AppCompatActivity() {
    private val PEGAR_CONTATO_REQ = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_act_result)
    }

}
