package com.example.test.api

import com.example.final_exam.model.Coffee
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api")
    suspend fun getAllProducts(): Response<Coffee>
}