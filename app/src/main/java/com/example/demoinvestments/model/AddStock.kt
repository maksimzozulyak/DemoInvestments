package com.example.demoinvestments.model

import android.content.Context
import android.os.Looper
import android.widget.Toast
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.ui.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException
import java.lang.Exception

fun addStock(token: String, viewModel: MainViewModel, context: Context) {
    GlobalScope.launch{
        try {
            viewModel.allStocksList().forEach {
                if (it.token == token){
                    Looper.prepare()
                    Toast.makeText(context,"You already have this stock", Toast.LENGTH_SHORT).show()
                    Looper.loop()
                    return@launch
                }
            }
            val stock = getData(token,context)
            if (stock.token != null) {
                viewModel.insert(getData(token,context))
            }
        } catch (e: NumberFormatException) {
            Looper.prepare()
            Toast.makeText(context,"Wrong ticker", Toast.LENGTH_SHORT).show()
            Looper.loop()
        }
    }
}

fun getData(token: String,context: Context) : Stock {
    try {
        val document = Jsoup.connect("https://ffin.ua/ru/stocks/$token").get()
        val name = document.select("h1[class=stock-header__info-company]").text()
        val logoUrl = document.select("div[class=stock-header__logo]").select("img").attr("src")
        var currency: String
        var currentPrice : Float
        try {
            val listOfPrice =
                document.select("div[class=curr-price curr-price--up]").text().split(' ')
            currentPrice = listOfPrice[0].toFloat()
            currency = listOfPrice[1]
        } catch (e: Exception) {
            val listOfPrice =
                document.select("div[class=curr-price curr-price--down]").text().split(' ')
            currentPrice = listOfPrice[0].toFloat()
            currency = listOfPrice[1]
        }
        return Stock(token, name, currentPrice, currency, logoUrl, 0f)
    } catch (e: IOException) {
        Looper.prepare()
        Toast.makeText(context,"Wrong ticker", Toast.LENGTH_SHORT).show()
        Looper.loop()
        return Stock()
    }
}