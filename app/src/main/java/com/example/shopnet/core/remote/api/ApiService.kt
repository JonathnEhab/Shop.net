package com.example.shopnet.core.remote.api

import com.example.shopnet.domain.product.ProductsItem
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductsItem>
}