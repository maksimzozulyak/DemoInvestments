package com.example.demoinvestments.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.content.SharedPreferences
import android.os.Parcelable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoinvestments.data.*
import java.io.Serializable


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
        if (SharedPreference.balance == null){
            value = 0f
        } else {
            value = SharedPreference.balance
        }
    }
    fun allStocks() = repository.allStocks()
    fun allStocksList() = repository.allStocksList()

}