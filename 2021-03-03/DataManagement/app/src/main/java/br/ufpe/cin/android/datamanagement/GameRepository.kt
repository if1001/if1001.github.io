package br.ufpe.cin.android.datamanagement

import android.content.Context
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

private const val GAME_PREFERENCES_NAME = "game_preferences"
private const val HIGH_SCORE_KEY = "maior_pontuacao"

class GameRepository private constructor(context: Context) {

    private val sharedPreferences = context.applicationContext.getSharedPreferences(
        GAME_PREFERENCES_NAME, Context.MODE_PRIVATE
    )

    private val _maiorPontuacao = MutableLiveData<Int>(sharedPreferences.getInt(HIGH_SCORE_KEY,0))
    val maiorPontuacao : LiveData<Int> = _maiorPontuacao

    fun persistirPontuacao(score:Int) {
        /*
        val e = sharedPreferences.edit()
        e.putInt(HIGH_SCORE_KEY,score)
        e.apply()
         */
        _maiorPontuacao.postValue(score)

        sharedPreferences.edit {
            putInt(HIGH_SCORE_KEY,score)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE : GameRepository? = null

        fun getInstance(context:Context) : GameRepository {
            return INSTANCE?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }
                val instance = GameRepository(context)
                INSTANCE = instance
                instance
            }
        }
    }


}