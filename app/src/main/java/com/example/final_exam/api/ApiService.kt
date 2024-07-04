package com.example.test.api

import com.example.final_exam.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getAllProducts(): Response<ProductResponse>
}