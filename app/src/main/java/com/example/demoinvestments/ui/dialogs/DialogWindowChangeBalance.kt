package com.example.demoinvestments.ui.dialogs

import android.content.Context
import android.os.Bundle
import android.text.InputFilter
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.example.demoinvestments.R
import com.example.demoinvestments.data.SharedPreference
import com.example.demoinvestments.model.addStock
import com.example.demoinvestments.ui.MainViewModel
import kotlinx.android.synthetic.main.add_stock_dialogwindow.*
import kotlinx.android.synthetic.main.change_balance_dialogwindow.*

class DialogWindowChangeBalance(context: Context) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.change_balance_dialogwindow)

        confirm_changing_balance_button.setOnClickListener {
            SharedPreference.balance = enter_balance_edittext.text.toString().toFloat()
            dismiss()
        }

        cancel_changing_balance_button.setOnClickListener {
            cancel()
        }
    }
}