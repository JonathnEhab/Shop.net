package com.example.shopnet.di

import com.example.shopnet.core.local.ProductDao
import com.example.shopnet.core.remote.api.ApiService
import com.example.shopnet.presenter.ui.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideNewsRepository(apiService: ApiService,dao: ProductDao): ProductRepository {
        return ProductRepository(apiService, dao)
    }

}