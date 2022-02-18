package com.example.demoinvestments.ui.action_fragment.sell_fragment

import androidx.lifecycle.ViewModel
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.data.Stock
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SellFragmentViewModel(private val repository: Repository) : ViewModel() {

    fun update(item: Stock) = GlobalScope.launch {
        repository.update(item)
    }
}