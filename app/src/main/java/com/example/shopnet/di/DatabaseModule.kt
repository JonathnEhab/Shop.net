package com.example.shopnet.di

import android.content.Context
import androidx.room.Room
import com.example.shopnet.core.local.ProductDao
import com.example.shopnet.core.local.ProductsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun getNewsInstance (@ApplicationContext context: Context) : ProductsDatabase {
        return Room.databaseBuilder(context
            , ProductsDatabase::class.java
            , "products_database")
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun newDao(productsDatabase: ProductsDatabase) : ProductDao {
        return productsDatabase.newProductDao()
    }
}