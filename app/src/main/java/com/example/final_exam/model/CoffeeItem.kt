package com.example.final_exam.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "app_db")
data class CoffeeItem(
    @SerializedName("description")
    val description: String,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("region")
    val region: String,
    @SerializedName("roast_level")
    val roastLevel: Int,
    @SerializedName("weight")
    val weight: Int
)