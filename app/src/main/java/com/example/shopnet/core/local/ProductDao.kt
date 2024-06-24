package com.example.shopnet.core.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shopnet.domain.product.ProductsItem

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductsItem>)

    @Query("SELECT * FROM products")
    suspend fun getProducts(): List<ProductsItem>
}
