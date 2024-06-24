package com.example.shopnet.presenter.ui.repository

import com.example.shopnet.core.local.ProductDao
import com.example.shopnet.core.remote.api.ApiService
import com.example.shopnet.domain.product.ProductsItem
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ProductRepository  @Inject constructor(private val apiService: ApiService, private val  dao: ProductDao){

    private val _productsData = MutableStateFlow<List<ProductsItem>?>(null)
    suspend fun getNews(): List<ProductsItem> {
        val response = apiService.getProducts()
        _productsData.value = response
        dao.insertProducts(response)
        return response
    }

    suspend fun getOfflineNews(): List<ProductsItem> {
        return dao.getProducts()
    }
}