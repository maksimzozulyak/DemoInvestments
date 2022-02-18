package com.example.demoinvestments.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "stocks")
data class Stock(

    @ColumnInfo(name = "token")
    val token : String? = null,
    @ColumnInfo(name = "name")
    val name : String? = null,
    @ColumnInfo(name = "currentPrice")
    var currentPrice : Float? = null,
    @ColumnInfo(name = "currency")
    val currency: String? = null,
    @ColumnInfo(name = "logoUrl")
    var logoUrl: String? = null,
    @ColumnInfo(name = "myStock")
    var myStock: Float? = null
) : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
