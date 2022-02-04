package com.example.demoinvestments.ui

import androidx.lifecycle.ViewModel
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.data.Stock
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewModel(private val repository: Repository) : ViewModel() {

    // In coroutines thread insert item in insert function.
    fun insert(item: Stock) = GlobalScope.launch {
        repository.insert(item)
    }

    // In coroutines thread delete item in delete function.
    fun delete(item: Stock) = GlobalScope.launch {
        repository.delete(item)
    }

    //Here we initialized allGroceryItems function with repository
    fun allGroceryItems() = repository.allStocks()

}