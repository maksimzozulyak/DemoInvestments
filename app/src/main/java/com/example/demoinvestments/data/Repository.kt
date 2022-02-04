package com.example.demoinvestments.data

class Repository(private val db: StockDatabase) {

    suspend fun insert(item: Stock) = db.getStocksDao().insert(item)
    suspend fun delete(item: Stock) = db.getStocksDao().delete(item)

    fun allStocks() = db.getStocksDao().getAllStocks()
}