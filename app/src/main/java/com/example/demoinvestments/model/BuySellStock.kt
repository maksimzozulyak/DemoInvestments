package com.example.demoinvestments.model

import android.util.Log
import android.widget.TextView
import com.example.demoinvestments.data.Stock
import com.example.demoinvestments.ui.MainViewModel

fun buyStock(stock : Stock, money: Float,viewModel: MainViewModel) {
    var newStock = stock;
    newStock.myStock = stock.myStock!! + money/stock.currentPrice!!
//    Values.balance = Values.balance!! - money
    viewModel.update(newStock)
    viewModel.balance.value = 5
}

fun sellStock(stock : Stock, money: Float,viewModel: MainViewModel) {
    var newStock = stock;
    newStock.myStock = stock.myStock!! - money/stock.currentPrice!!
//    Values.balance = Values.balance!! - money
    viewModel.update(newStock)
}