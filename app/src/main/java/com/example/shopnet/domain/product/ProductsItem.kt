package com.example.shopnet.domain.product

import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "products")
data class ProductsItem(
    val category: String,
    val description: String,
    @PrimaryKey val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
) : Parcelable
