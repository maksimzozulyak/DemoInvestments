package com.example.demoinvestments.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.lang.Exception
import android.content.SharedPreferences
import com.example.demoinvestments.data.*


class MainViewModel(private val repository: Repository, private val sharedPreference : SharedPreferences) : ViewModel() {

    // In coroutines thread insert item in insert function.
    fun insert(item: Stock) = GlobalScope.launch {
        repository.insert(item)
    }

    // In coroutines thread delete item in delete function.
    fun delete(item: Stock) = GlobalScope.launch {
        repository.delete(item)
    }

    fun update(item: Stock) = GlobalScope.launch {
        repository.update(item)
    }

    var balance = sharedPreference.intLiveData("balance" , 228)

    fun allStocks() = repository.allStocks()
    fun allStocksList() = repository.allStocksList()

}