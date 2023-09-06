package com.example.testunify.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testunify.model.Product
import com.example.testunify.viewmodel.HomeViewModel

@Composable
fun TopCardView() {

    val viewModel: HomeViewModel = viewModel()
    val singleProduct: State<Product> = viewModel.singleProduct.collectAsState()


    Card(
        elevation = 10.dp,
        modifier = Modifier.padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row {
                    Text(
                        text = "Product ID -",
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    singleProduct.value.id?.let {
                        Text(
                            text = it.toString(),
                            modifier = Modifier
                                .padding(end = 8.dp)
                        )
                    }
                }
               Row {
                   Text(
                       text = "Amount -",
                       modifier = Modifier
                           .padding(start = 8.dp)
                           .align(Alignment.CenterVertically)
                   )
                   Text(
                       text = singleProduct.value.price.toString(),
                       modifier = Modifier
                           .padding(start = 8.dp)
                           .align(Alignment.CenterVertically)
                   )
               }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Color.Gray)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),

            ) {
                Text(
                    text = "Category - ",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                )
                singleProduct.value.category?.let {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(0.5.dp)
                    .background(Color.Gray)
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                backgroundColor = Color.Yellow
            ) {
                singleProduct.value.description?.let {
                    Text(
                        text = it,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }

}