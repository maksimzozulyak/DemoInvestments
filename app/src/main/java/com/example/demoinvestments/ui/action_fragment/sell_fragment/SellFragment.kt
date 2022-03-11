package com.example.demoinvestments.ui.action_fragment.sell_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.model.data.Repository
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.model.data.StockDatabase
import com.example.demoinvestments.databinding.SellFragmentBinding
import com.example.demoinvestments.model.sellStock
import kotlinx.android.synthetic.main.sell_fragment.*

class SellFragment : Fragment() , SeekBar.OnSeekBarChangeListener{

    private var _binding: SellFragmentBinding? = null
    private var sellAmount : Int = 0
    private lateinit var viewModel: SellFragmentViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val repository = Repository(StockDatabase(requireContext()))
        viewModel =
            ViewModelProvider(
                this,
                SellFragmentViewModelFactory(repository)
            )[SellFragmentViewModel::class.java]

        _binding = SellFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var stock : Stock = arguments?.getSerializable("stock") as Stock

        min_sell_textview.text = "0"
        max_sell_textview.text = (stock.myStock!!.times(stock.currentPrice!!))!!.toInt().toString()

        sell_seekbar.setOnSeekBarChangeListener(this)
        sell_seekbar.max = (stock.myStock!!.times(stock.currentPrice!!))!!.toInt()

        sell_button.setOnClickListener {
            sellStock(stock,sellAmount.toFloat(),viewModel)
            activity?.finish()
        }
        cancel_sell_button.setOnClickListener {
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        sell_textview.text = p1.toString()
        sellAmount = p1
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}