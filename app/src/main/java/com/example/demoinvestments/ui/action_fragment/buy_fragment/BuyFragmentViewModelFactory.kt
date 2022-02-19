package com.example.demoinvestments.ui.action_fragment.buy_fragment

import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.model.data.Repository

class BuyFragmentViewModelFactory(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return BuyFragmentViewModel(repository) as T
    }
}