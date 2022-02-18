package com.example.demoinvestments.model

import android.util.Log
import com.example.demoinvestments.data.Stock
import com.example.demoinvestments.ui.MainViewModel
import org.jsoup.Jsoup
import java.lang.Exception

suspend fun updatePrice(viewModel: MainViewModel, list: List<Stock>) {
    list.forEach { stock ->
        val document = Jsoup.connect("https://ffin.ua/ru/stocks/${stock.token}").get()
        var currentPrice : Float
        try {
            var listOfPrice =
                document.select("div[class=curr-price curr-price--up]").text()
                    .split(' ')
            currentPrice = listOfPrice[0].toFloat()
        } catch (e: Exception) {
            var listOfPrice =
                document.select("div[class=curr-price curr-price--down]").text()
                    .split(' ')
            currentPrice = listOfPrice[0].toFloat()
        }
        val newStock = stock
        newStock.currentPrice = currentPrice
        viewModel.update(newStock)
    }
}