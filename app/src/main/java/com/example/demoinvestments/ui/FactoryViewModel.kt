package com.example.demoinvestments.ui

import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.data.Repository

class FactoryViewModel(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}