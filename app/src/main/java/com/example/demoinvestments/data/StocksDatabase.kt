package com.example.demoinvestments.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Stock::class], version = 1)
abstract class StockDatabase : RoomDatabase() {

    abstract fun getStocksDao(): StocksDao

    companion object {
        @Volatile
        private var instance: StockDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, StockDatabase::class.java, "StockDatabase.db").build()
    }
}