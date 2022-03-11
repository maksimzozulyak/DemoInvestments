package com.example.demoinvestments.ui.action_fragment.buy_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demoinvestments.model.data.Repository
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.model.data.StockDatabase
import com.example.demoinvestments.databinding.BuyFragmentBinding
import com.example.demoinvestments.model.buyStock
import com.example.demoinvestments.model.data.SharedPreference
import kotlinx.android.synthetic.main.buy_fragment.*

class BuyFragment : Fragment() {

    private var _binding: BuyFragmentBinding? = null
    private lateinit var viewModel: BuyFragmentViewModel
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
                BuyFragmentViewModelFactory(repository)
            )[BuyFragmentViewModel::class.java]

        _binding = BuyFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stock : Stock = arguments?.getSerializable("stock") as Stock

        buy_button.setOnClickListener {
            if (buy_edittext.text.isNotEmpty()){
                try {
                    if (buy_edittext.text.toString().toFloat() > SharedPreference.balance!!){
                        Toast.makeText(activity,"You don`t have enough money", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        buyStock(stock, buy_edittext.text.toString().toFloat(), viewModel)
                        activity?.finish()
                    }
                } catch (e : NumberFormatException) {
                    Toast.makeText(activity,"Wrong records", Toast.LENGTH_SHORT).show()
                }
            }
        }
        cancel_buy_button.setOnClickListener {
            activity?.finish()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
