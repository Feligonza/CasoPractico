package com.felipe.casopractico.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.felipe.casopractico.model.Propiedad

@Database(entities = [Propiedad::class], version = 1, exportSchema = false)

abstract class PropiedadDatabase() : RoomDatabase() {

    abstract fun PropiedadDao(): PropiedadDao

    companion object {
        @Volatile
        private var INSTANCE: PropiedadDatabase? = null

        fun getDatabase(context: android.content.Context): PropiedadDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PropiedadDatabase::class.java,
                    "propiedad.database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
