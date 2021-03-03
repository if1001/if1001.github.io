package br.ufpe.cin.android.datamanagement

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Professor::class], version = 1)
abstract class ProfessorDB : RoomDatabase() {
    abstract fun professorDAO() : ProfessorDAO

    companion object {
        @Volatile
        private var INSTANCE : ProfessorDB? = null
        fun getInstance(c: Context) : ProfessorDB {
            return INSTANCE ?: synchronized(this) {
                INSTANCE?.let {
                    return it
                }

                val instance = Room.databaseBuilder(
                    c.applicationContext,
                    ProfessorDB::class.java,
                    "professores.db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}