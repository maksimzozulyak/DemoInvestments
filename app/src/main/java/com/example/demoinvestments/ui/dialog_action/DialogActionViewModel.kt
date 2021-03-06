package com.example.demoinvestments.ui.dialog_action

import androidx.lifecycle.ViewModel
import com.example.demoinvestments.model.data.Repository
import com.example.demoinvestments.model.data.Stock
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DialogActionViewModel(private val repository: Repository) : ViewModel(){

    fun insert(item: Stock) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: Stock) = GlobalScope.launch {
        repository.delete(item)
    }

    fun update(item: Stock) = GlobalScope.launch {
        repository.update(item)
    }

    fun allStocks() = repository.allStocks()
    fun allStocksList() = repository.allStocksList()

}