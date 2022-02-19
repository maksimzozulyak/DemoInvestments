package com.example.demoinvestments.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoinvestments.ui.MainViewModel

object  SharedPreference {
    private var sharedPreferences: SharedPreferences? = null

    private lateinit var viewModel: MainViewModel

    fun setViewModel(viewModel: MainViewModel) {
        this.viewModel = viewModel
    }

    fun setup(context: Context) {
        sharedPreferences =
            context.getSharedPreferences("demoinvestments.sharedprefs", Context.MODE_PRIVATE)
    }
    var balance: Float?
        get() = Key.BALANCE.getFloat()
        set(value) {Key.BALANCE.setFloat(value)
                    viewModel.balance.value = value
                    }

    private enum class Key {
        BALANCE;

        fun getFloat(): Float? =
            if (sharedPreferences!!.contains(name)) sharedPreferences!!.getFloat(name, 0f) else null

        fun setFloat(value: Float?) =
            value?.let { sharedPreferences!!.edit { putFloat(name, value) } } ?: remove()

        fun remove() = sharedPreferences!!.edit { remove(name) }
    }
}
