package br.ufpe.cin.android.lifecycle

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class OutroViewModel(val c : Application) : AndroidViewModel(c) {
    val texto : String = c.getString(R.string.app_name)
}