package com.example.demoinvestments.model

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import com.example.demoinvestments.R
import com.example.demoinvestments.data.Stock
import com.example.demoinvestments.ui.MainViewModel
import kotlinx.android.synthetic.main.add_stock_dialogwindow.cancel_button
import kotlinx.android.synthetic.main.buy_stock_dialogwindow.*

class DialogWindowBuyingStock(context: Context, private val viewModel: MainViewModel, private val stock: Stock) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.buy_stock_dialogwindow)

        stock_name_textview.text = stock.name

        buy_button.setOnClickListener {
            try {
                buyStock(
                    stock,
                    enter_token_edittext.text.toString().toFloat(),
                    viewModel
                )
            } catch (e: NumberFormatException) {
            }
            dismiss()
        }
        sell_button.setOnClickListener {
            try {
                sellStock(
                    stock,
                    enter_token_edittext.text.toString().toFloat(),
                    viewModel
                )
            } catch (e: NumberFormatException) {
            }
            dismiss()
        }

        delete_button.setOnClickListener{
            viewModel.delete(stock)
            dismiss()
        }

        cancel_button.setOnClickListener {
            cancel()
        }
    }
}