package com.example.shopnet.domain.product

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RatingConverter {

    @TypeConverter
    fun fromRating(rating: Rating?): String? {
        if (rating == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Rating>() {}.type
        return gson.toJson(rating, type)
    }

    @TypeConverter
    fun toRating(ratingString: String?): Rating? {
        if (ratingString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<Rating>() {}.type
        return gson.fromJson(ratingString, type)
    }
}
