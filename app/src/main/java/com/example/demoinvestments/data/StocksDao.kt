package com.example.demoinvestments.data

import androidx.lifecycle.LiveData
import androidx.room.*
import java.io.Serializable

@Dao
interface StocksDao : Serializable {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Stock)

    @Delete
    suspend fun delete(item: Stock)

    @Update
    suspend fun update(item: Stock)

    @Query("SELECT * FROM stocks")
    fun getAllStocks(): LiveData<List<Stock>>

    @Query("SELECT * FROM stocks")
    fun getStockList(): List<Stock>
}