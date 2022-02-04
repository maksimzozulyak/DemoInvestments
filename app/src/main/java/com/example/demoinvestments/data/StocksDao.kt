package com.example.demoinvestments.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StocksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Stock)

    @Delete
    suspend fun delete(item: Stock)

    @Query("SELECT * FROM stocks")
    fun getAllStocks(): LiveData<List<Stock>>
}