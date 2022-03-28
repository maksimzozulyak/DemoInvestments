package com.example.demoinvestments.model

import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.ui.MainViewModel
import org.jsoup.Jsoup
import java.lang.Exception

fun updatePrice(viewModel: MainViewModel, list: List<Stock>) {
    list.forEach { stock: Stock ->
        val currentPrice: Float
            val document = Jsoup.connect("https://ffin.ua/ru/stocks/${stock.token}").get()
            currentPrice = try {
                val listOfPrice =
                    document.select("div[class=curr-price curr-price--up]").text()
                        .split(' ')
                listOfPrice[0].toFloat()
            } catch (e: Exception) {
                val listOfPrice =
                    document.select("div[class=curr-price curr-price--down]").text()
                        .split(' ')
                listOfPrice[0].toFloat()
            }
        stock.currentPrice = currentPrice
        viewModel.update(stock)
    }
}