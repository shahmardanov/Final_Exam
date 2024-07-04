package com.example.test.api

import android.util.Log
import com.example.final_exam.model.ProductResponse
import com.example.final_exam.model.ProductResponseItem
import com.example.test.local.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiService: ApiService,
    private val productDao: ProductDao
) {

    suspend fun getProduct() = apiService.getAllProducts()

    fun addProductsLocal(productResponse: ProductResponseItem) =
        productDao.addProducts(productResponse)


    fun getAllProductsLocal() = flow {
        try {
            val response = productDao.getAllProducts()
            emit(response)
        } catch (e: Exception) {
            Log.e("error", e.localizedMessage.toString())
        }
    }.flowOn(Dispatchers.IO)
}