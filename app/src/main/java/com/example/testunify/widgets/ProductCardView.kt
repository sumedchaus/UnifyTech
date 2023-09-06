package com.example.testunify.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testunify.model.Product


@Composable
fun ProductListItem(product: Product) {

    var isCardSelected by remember { mutableStateOf(false) }

    val cardColor = if (isCardSelected) {
        Color.Red
    } else {
        Color.White
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                isCardSelected = !isCardSelected
            }
            .background(cardColor),

        ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            val painter = rememberAsyncImagePainter(
                product.image,
            )

            Image(
                painter = painter,
                contentDescription = "test",
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp),
                contentScale = ContentScale.Fit,
            )
        }
    }
}



