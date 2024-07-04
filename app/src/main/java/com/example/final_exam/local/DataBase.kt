package com.example.test.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.final_exam.model.ProductResponse
import com.example.final_exam.model.ProductResponseItem

@Database(entities = [ProductResponseItem::class], version = 4)
abstract class DataBase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}