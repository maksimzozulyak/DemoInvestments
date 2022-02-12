package com.example.demoinvestments.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.data.Repository
import android.preference.PreferenceManager

import android.content.SharedPreferences




class FactoryViewModel(private val repository: Repository, context: Context): ViewModelProvider.NewInstanceFactory() {

    var sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)

    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository, sharedPreference) as T
    }
}