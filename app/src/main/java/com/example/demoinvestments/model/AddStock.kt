package com.example.demoinvestments.model

import com.example.demoinvestments.data.Stock
import com.example.demoinvestments.ui.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException
import java.lang.Exception

fun addStock(token : String, viewModel: MainViewModel) {
    GlobalScope.launch{
        try {
            val stock = getData(token)
            if (stock.token != null) {
                viewModel.insert(getData(token))
            }
        } catch (e: NumberFormatException) {
        }
    }
}

fun getData(token: String) : Stock {
    try {
        val document = Jsoup.connect("https://ffin.ua/ru/stocks/$token").get()
        val name = document.select("h1[class=stock-header__info-company]").text()
        val logoUrl = document.select("div[class=stock-header__logo]").select("img").attr("src")
        var currency = ""
        var currentPrice = 0f
        try {
            var listOfPrice =
                document.select("div[class=curr-price curr-price--up]").text().split(' ')
            currentPrice = listOfPrice[0].toFloat()
            currency = listOfPrice[1]
        } catch (e: Exception) {
            var listOfPrice =
                document.select("div[class=curr-price curr-price--down]").text().split(' ')
            currentPrice = listOfPrice[0].toFloat()
            currency = listOfPrice[1]
        }
        return Stock(token, name, currentPrice, currency, logoUrl, 0f)
    } catch (e: IOException) {
        return Stock()
    }
}