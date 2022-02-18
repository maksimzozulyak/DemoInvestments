package com.example.demoinvestments.ui.action_fragment.buy_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.data.Stock
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BuyFragmentViewModel(private val repository: Repository) : ViewModel(){

    fun update(item: Stock) = GlobalScope.launch {
        repository.update(item)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}