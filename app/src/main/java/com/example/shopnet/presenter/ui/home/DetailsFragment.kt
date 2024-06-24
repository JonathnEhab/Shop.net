package com.example.shopnet.presenter.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.shopnet.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    var _binding : FragmentDetailsBinding?= null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("title")
        val image = arguments?.getString("image")
        val description = arguments?.getString("description")
        val category = arguments?.getString("category")
        val price = arguments?.getString("price")
        val rate = arguments?.getString("rate")

        Glide.with(requireContext()).load(image).into(binding.imageProduct)
        binding.nameProduct.text=title
        binding.descriptionProduct.text=description
        binding.categoryProduct.text=category
        binding.priceProduct.text=price+" EGP"
        binding.rateProduct.text=rate
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }


}