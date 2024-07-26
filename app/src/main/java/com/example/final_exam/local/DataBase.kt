package com.example.test.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.final_exam.model.CoffeeItem
import com.example.final_exam.model.ProductResponse
import com.example.final_exam.model.ProductResponseItem

@Database(entities = [CoffeeItem::class], version = 7)
abstract class DataBase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}