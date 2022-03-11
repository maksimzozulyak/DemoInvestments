package com.example.demoinvestments.ui.dialogs

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.example.demoinvestments.R
import com.example.demoinvestments.model.addStock
import com.example.demoinvestments.ui.MainViewModel
import kotlinx.android.synthetic.main.add_stock_dialogwindow.*

class DialogWindowAddingStock(val context: Activity, private val viewModel: MainViewModel) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_stock_dialogwindow)

        confirm_adding_button.setOnClickListener {
            addStock(enter_token_edittext.text.toString(),viewModel,context)
            dismiss()
        }

        enter_token_edittext.filters = enter_token_edittext.filters + InputFilter.AllCaps()

        cancel_adding_button.setOnClickListener {
            cancel()
        }
    }
}