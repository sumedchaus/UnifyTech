package com.example.testunify.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testunify.model.Product
import com.example.testunify.viewmodel.HomeViewModel
import com.example.testunify.widgets.ProductListItem
import com.example.testunify.widgets.TopBar
import com.example.testunify.widgets.TopCardView


@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { TopBar() },
        content = { padding ->

            Column(modifier = Modifier.padding()) {
                TopCardView()
                Text(
                    text = "Choose other Products",
                    Modifier.padding(start = 16.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                ProductListScreen()
            }
        }

    )
}


@Composable
fun ProductListScreen() {
    val viewModel: HomeViewModel = viewModel()
    val products: State<List<Product>> = viewModel.products.collectAsState()

    LazyRow {
        items(products.value) { product ->
            ProductListItem(product)
        }
    }
}


