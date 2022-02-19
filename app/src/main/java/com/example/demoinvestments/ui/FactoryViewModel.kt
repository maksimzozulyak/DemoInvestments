package com.example.demoinvestments.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.model.data.Repository


class FactoryViewModel(private val repository: Repository, context: Context): ViewModelProvider.NewInstanceFactory() {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}