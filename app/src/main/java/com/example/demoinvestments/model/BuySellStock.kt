package com.example.demoinvestments.model

import com.example.demoinvestments.model.data.SharedPreference
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.ui.action_fragment.buy_fragment.BuyFragmentViewModel
import com.example.demoinvestments.ui.action_fragment.sell_fragment.SellFragmentViewModel

fun buyStock(stock : Stock, money: Float, viewModel: BuyFragmentViewModel) {
    var newStock = stock;
    newStock.myStock = stock.myStock!! + money/stock.currentPrice!!
    SharedPreference.balance = SharedPreference.balance!! - money
    viewModel.update(newStock)
}

fun sellStock(stock : Stock, money: Float, viewModel: SellFragmentViewModel) {
    var newStock = stock;
    newStock.myStock = stock.myStock!! - money/stock.currentPrice!!
    SharedPreference.balance = SharedPreference.balance!! + money
    viewModel.update(newStock)
}