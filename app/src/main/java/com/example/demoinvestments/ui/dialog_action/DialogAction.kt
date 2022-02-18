package com.example.demoinvestments.ui.dialog_action

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.demoinvestments.R
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.data.Stock
import com.example.demoinvestments.data.StockDatabase
import com.example.demoinvestments.ui.FactoryViewModel
import com.example.demoinvestments.ui.MainActivity
import com.example.demoinvestments.ui.MainViewModel
import com.example.demoinvestments.ui.action_fragment.buy_fragment.BuyFragmentViewModel
import kotlinx.android.synthetic.main.dialog_action.*

class DialogAction : AppCompatActivity() {
    lateinit var viewModel: DialogActionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_action)

        val repository = Repository(StockDatabase(this))
        viewModel = ViewModelProvider(this, DialogActionViewModelFactory(repository))[DialogActionViewModel::class.java]

        val stock = intent.getSerializableExtra("stock") as Stock

        stock_name_textview.text = stock.name

        var bundle = bundleOf("stock" to stock)

        Navigation.findNavController(this,R.id.host_fragment_dialog_activity).navigate(R.id.mainFragment, bundle)
    }

}