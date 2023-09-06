package com.example.testunify.repository

import com.example.testunify.api.ApiService
import com.example.testunify.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiService: ApiService) {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products : StateFlow<List<Product>>
        get() = _products

    private val _singleProduct = MutableStateFlow<Product>(Product())
    val singleProduct : StateFlow<Product>
        get() = _singleProduct




    suspend fun getProducts(){
        val response = apiService.getProducts()

        if (response.isSuccessful && response.body() != null){
            _products.emit(response.body()!!)
        }
    }

    suspend fun getSingleProduct(){
        val response = apiService.getSingleProduct()

        if (response.isSuccessful && response.body() != null){
            _singleProduct.emit(response.body()!!)
        }
    }


}