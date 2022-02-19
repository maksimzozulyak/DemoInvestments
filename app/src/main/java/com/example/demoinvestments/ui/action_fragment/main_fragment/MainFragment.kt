package com.example.demoinvestments.ui.action_fragment.main_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.demoinvestments.R
import com.example.demoinvestments.model.data.Repository
import com.example.demoinvestments.model.data.SharedPreference
import com.example.demoinvestments.model.data.Stock
import com.example.demoinvestments.model.data.StockDatabase
import com.example.demoinvestments.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    lateinit var viewModel: MainFragmentViewModel
    private val binding get() = _binding!!

    var stock = Stock()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val repository = Repository(StockDatabase(requireContext()))
        viewModel =
            ViewModelProvider(this, MainFragmentViewModelFactory(repository))[MainFragmentViewModel::class.java]

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.getSerializable("stock") != null) {
            stock = arguments?.getSerializable("stock") as Stock
        }

        var bundle = bundleOf("stock" to stock)

        main_buy_button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_buyFragment,bundle)
        }
        main_sell_button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_sellFragment,bundle)
        }
        main_cancel_button.setOnClickListener {
            activity?.finish()
        }
        main_delete_button.setOnLongClickListener {
            viewModel.delete(stock)
            SharedPreference.balance = SharedPreference.balance!! + (stock.myStock!! * stock.currentPrice!!)
            activity?.finish()
            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}