package com.example.demoinvestments.ui.action_fragment.main_fragment

import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.ui.action_fragment.buy_fragment.BuyFragmentViewModel

class MainFragmentViewModelFactory(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(repository) as T
    }
}