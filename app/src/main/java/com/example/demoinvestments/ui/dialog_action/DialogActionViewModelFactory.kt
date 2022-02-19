package com.example.demoinvestments.ui.dialog_action

import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.model.data.Repository

class DialogActionViewModelFactory(private val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return DialogActionViewModel(repository) as T
    }
}