package com.example.demoinvestments.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stocks")
data class Stock(

    @ColumnInfo(name = "token")
    val token : String?,
    @ColumnInfo(name = "name")
    val name : String?,
    @ColumnInfo(name = "currentPrice")
    var currentPrice : Float?,
    @ColumnInfo(name = "currency")
    val currency: String?,
    @ColumnInfo(name = "logoUrl")
    var logoUrl: String?,
    @ColumnInfo(name = "myStock")
    var myStock: Float?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
