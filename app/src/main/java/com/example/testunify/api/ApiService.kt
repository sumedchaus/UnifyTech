package com.example.testunify.api

import com.example.testunify.model.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>

    @GET("/products/1")
    suspend fun getSingleProduct(): Response<Product>
}