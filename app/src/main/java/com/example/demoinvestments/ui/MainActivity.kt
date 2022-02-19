package com.example.demoinvestments.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoinvestments.R
import com.example.demoinvestments.model.data.*
import com.example.demoinvestments.model.recyclerview.RecyclerViewAdapter
import com.example.demoinvestments.ui.dialogs.DialogWindowAddingStock
import com.example.demoinvestments.model.updatePrice
import com.example.demoinvestments.ui.dialogs.DialogWindowChangeBalance
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SharedPreference.setup(this)

        val repository = Repository(StockDatabase(this))
        val factory = FactoryViewModel(repository, this)

        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        SharedPreference.setViewModel(viewModel)

        val adapter = RecyclerViewAdapter(listOf(), viewModel,this)
        stocks_recyclerview.layoutManager = LinearLayoutManager(this)
        stocks_recyclerview.adapter = adapter

        GlobalScope.launch {
            updatePrice(viewModel,viewModel.allStocksList())
        }

        viewModel.allStocks().observe(this, Observer {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        add_stock_button.setOnClickListener {
            DialogWindowAddingStock(this,viewModel).show()
        }

        adapter.setListener {
            for (fragment in supportFragmentManager?.getFragments()!!) {
            supportFragmentManager?.beginTransaction()?.remove(fragment)?.commit()
            }
        }
        balance_textview.setOnClickListener {
            DialogWindowChangeBalance(this).show()
        }
        viewModel.balance.observe(this) {
            balance_textview.text = it.toInt().toString()
        }
    }
}