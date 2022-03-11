package com.example.demoinvestments.ui.dialog_action

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.demoinvestments.R
import com.example.demoinvestments.model.data.Repository
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.model.data.StockDatabase
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

        val bundle = bundleOf("stock" to stock)

        Navigation.findNavController(this,R.id.host_fragment_dialog_activity).navigate(R.id.mainFragment, bundle)
    }

}