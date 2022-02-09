package com.example.demoinvestments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoinvestments.R
import com.example.demoinvestments.data.Repository
import com.example.demoinvestments.data.Stock
import com.example.demoinvestments.data.StockDatabase
import com.example.demoinvestments.data.recyclerview.RecyclerViewAdapter
import com.example.demoinvestments.model.DialogWindowAddingStock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    lateinit var list: List<Stock>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groceryRepository = Repository(StockDatabase(this))
        val factory = FactoryViewModel(groceryRepository)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        val adapter = RecyclerViewAdapter(listOf(), viewModel)
        stocks_recyclerview.layoutManager = LinearLayoutManager(this)
        stocks_recyclerview.adapter = adapter

        viewModel.allStocks().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        add_stock_button.setOnClickListener {
            DialogWindowAddingStock(this,viewModel).show()
        }
    }
}