package com.example.testunify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testunify.model.Product
import com.example.testunify.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository): ViewModel() {

    val products : StateFlow<List<Product>>
        get() = repository.products
    val singleProduct : StateFlow<Product>
        get() = repository.singleProduct

    init {

        viewModelScope.launch {
            repository.getProducts()
        }
        viewModelScope.launch {
            repository.getSingleProduct()
        }
    }
}