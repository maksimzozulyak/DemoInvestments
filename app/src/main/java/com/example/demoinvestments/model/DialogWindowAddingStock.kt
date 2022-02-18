package com.example.demoinvestments.model

import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.example.demoinvestments.R
import com.example.demoinvestments.ui.MainViewModel
import kotlinx.android.synthetic.main.add_stock_dialogwindow.*

class DialogWindowAddingStock(context: Context, private val viewModel: MainViewModel) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_stock_dialogwindow)

        confirm_button.setOnClickListener {
            addStock(enter_token_edittext.text.toString(),viewModel)
            dismiss()
        }

        enter_token_edittext.setFilters(enter_token_edittext.getFilters() + InputFilter.AllCaps())

        cancel_button.setOnClickListener {
            cancel()
        }
    }
}