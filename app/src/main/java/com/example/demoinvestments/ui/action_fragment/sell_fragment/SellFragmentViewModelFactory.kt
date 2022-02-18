package com.example.demoinvestments.ui.action_fragment.sell_fragment

import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.ui.action_fragment.buy_fragment.BuyFragmentViewModel

class SellFragmentViewModelFactory(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return SellFragmentViewModel(repository) as T
    }
}