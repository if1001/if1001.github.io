package br.ufpe.cin.android.datamgmt

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pessoa::class], version = 1)
abstract class PessoaDB : RoomDatabase() {
    abstract fun pessoaDAO() : PessoaDAO

    //Singleton
    companion object {
        private var INSTANCE : PessoaDB? = null
        fun getDatabase(c: Context) : PessoaDB {
            if (INSTANCE==null) {
                synchronized(PessoaDB::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        c.applicationContext,
                        PessoaDB::class.java,
                        "pessoas.db"
                    ).build()
                }
            }

            return INSTANCE!!
        }
    }
}