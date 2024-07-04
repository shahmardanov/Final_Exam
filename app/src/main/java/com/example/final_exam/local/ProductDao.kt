package com.example.test.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.final_exam.model.ProductResponse
import com.example.final_exam.model.ProductResponseItem

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProducts(products: ProductResponseItem)

    @Query("SELECT * FROM products")
   suspend fun getAllProducts(): List<ProductResponseItem>

}