package com.example.demoinvestments.ui.action_fragment.main_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.data.Stock
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFragmentViewModel(private var repository: Repository) : ViewModel() {

    fun delete(item: Stock) = GlobalScope.launch {
        repository.delete(item)
    }
}