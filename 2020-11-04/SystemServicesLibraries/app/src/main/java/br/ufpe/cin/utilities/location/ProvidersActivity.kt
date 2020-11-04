package br.ufpe.cin.utilities.location

import android.app.Activity
import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import br.ufpe.cin.utilities.R
import kotlinx.android.synthetic.main.activity_list.*

class ProvidersActivity : Activity() {
    var mgr : LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        listView.setOnItemClickListener { l, v, position, id ->
            val provider = l.adapter.getItem(position) as String
            var txt = "desabilitado"

            if (mgr!!.isProviderEnabled(provider)) {
                txt = "habilitado"
            }

            Toast.makeText(this, "$provider - $txt", Toast.LENGTH_SHORT).show()
        }

        mgr = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val providers = mgr!!.allProviders

        //apenas habilitados
        //providers = mgr.getProviders(true);

        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, providers)
    }
}