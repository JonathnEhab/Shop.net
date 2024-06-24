package com.example.shopnet.presenter.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopnet.domain.product.ProductsItem
import com.example.shopnet.presenter.ui.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(private val repository: ProductRepository) :ViewModel(){
    private val _products= MutableStateFlow<List<ProductsItem>?>(null)
    val products :StateFlow<List<ProductsItem>?> = _products

    fun fetchProducts(){
        viewModelScope.launch {
            try {
               val response = repository.getNews()
                _products.value=response
                Log.e("TAG", "fetchProducts: ", )
            }catch (e :Exception) {
                repository.getOfflineNews()?.let {
                    _products.value = it
                }
            }
        }

    }
}