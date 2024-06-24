package com.example.shopnet.core.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.shopnet.domain.product.ProductsItem
import com.example.shopnet.domain.product.RatingConverter

@Database(entities = [ProductsItem::class], version = 12, exportSchema = false)
@TypeConverters(RatingConverter::class)
abstract class ProductsDatabase: RoomDatabase() {
    abstract fun newProductDao() :ProductDao
}