package com.example.demoinvestments.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.model.data.*


class MainViewModel(private val repository: Repository) : ViewModel() {

    fun insert(item: Stock) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: Stock) = GlobalScope.launch {
        repository.delete(item)
    }

    fun update(item: Stock) = GlobalScope.launch {
        repository.update(item)
    }

    var balance = MutableLiveData<Float>().apply {
        value = if (SharedPreference.balance == null){
            0f
        } else {
            SharedPreference.balance
        }
    }
    fun allStocks() = repository.allStocks()
    fun allStocksList() = repository.allStocksList()

}