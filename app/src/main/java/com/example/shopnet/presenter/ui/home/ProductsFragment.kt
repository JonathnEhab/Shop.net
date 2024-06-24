package com.example.shopnet.presenter.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopnet.databinding.FragmentProductsBinding
import com.example.shopnet.presenter.adapter.ProductsAdapter
import com.example.shopnet.presenter.ui.viewModel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : Fragment() {
    var _binding : FragmentProductsBinding?= null
    val binding get() = _binding!!
    private val viewModel :ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.productsShimmer.startShimmer()
        val productsAdapter=ProductsAdapter{title , image, description, category, price,rate ->
            findNavController().navigate(ProductsFragmentDirections.actionProductsFragmentToDetailsFragment(
                title,image,description,category,price,rate
            ))

        }
        binding.productsRecycler.apply {
            layoutManager= LinearLayoutManager(requireContext())
            adapter = productsAdapter
        }
        viewModel.fetchProducts()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.products.collect{ products ->
                 products?.let {
                     productsAdapter.submitList(it)
                     binding.productsShimmer.visibility=View.GONE
                     binding.productsRecycler.visibility=View.VISIBLE
                     binding.productsShimmer.stopShimmer()
                 }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}