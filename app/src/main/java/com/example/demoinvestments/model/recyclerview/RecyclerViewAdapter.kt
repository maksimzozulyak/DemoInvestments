package com.example.demoinvestments.model.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.demoinvestments.R
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.ui.MainActivity
import com.example.demoinvestments.ui.MainViewModel
import com.example.demoinvestments.ui.dialog_action.DialogAction
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.stock_item.view.*
import java.lang.IllegalArgumentException

class RecyclerViewAdapter(var list: List<Stock>, private var activity: MainActivity) :
    RecyclerView.Adapter<RecyclerViewAdapter.StockViewHolder>() {

    private var listener: (() -> Unit)? = null

    fun setListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    class StockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StockViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.stock_item, parent, false)
        return StockViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    override fun onBindViewHolder(holder: StockViewHolder, position: Int) {
        val currentStock = list[position]
        with(holder.itemView) {
            name_textview.text = currentStock.name
            token_textview.text = currentStock.token
            price_textview.text = currentStock.currentPrice.toString()
            currency_textview.text = currentStock.currency
            mystock_textview.text = "%.1f".format(currentStock.myStock)
            mystock_money_textview.text =
                (currentStock.myStock!! * currentStock.currentPrice!!).toInt().toString()
            try {
                Picasso.get().load(currentStock.logoUrl).into(logo_imageview)
            } catch (e: IllegalArgumentException) {
            }

            stockLayout.setOnClickListener {
                val intent = Intent(activity, DialogAction::class.java)
                intent.putExtra("stock", currentStock)
                startActivity(activity, intent, null)
            }
        }
    }
}
