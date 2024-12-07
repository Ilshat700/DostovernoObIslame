package com.ilshatcompany.dostovernoobislame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BooksScreen() {
    // Контент страницы "Книги"
    TitleOfBooksScreen()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray)
    ) {
        itemsIndexed(
            listOf(
                ItemRowModel(R.drawable.java1, "qwerty"),
                ItemRowModel(R.drawable.java2, "uiop"),
                ItemRowModel(R.drawable.java3, "asdfg"),
                ItemRowModel(R.drawable.java4, "hjk"),
                ItemRowModel(R.drawable.kzn, "qwe"),
                ItemRowModel(R.drawable.kotlin, "tyqwer"),
                ItemRowModel(R.drawable.ubuntu, "qert"),
            )
        ) { index, item ->
            MyRow(item = item)
        }
    }


    LazyColumn(
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight(
        )
    ) {
        itemsIndexed(
            listOf(
                ItemRowModel(R.drawable.java1, "qwerty"),
                ItemRowModel(R.drawable.java2, "uiop"),
                ItemRowModel(R.drawable.java3, "asdfg"),
                ItemRowModel(R.drawable.java4, "hjk"),
                ItemRowModel(R.drawable.kzn, "qwe"),
                ItemRowModel(R.drawable.kotlin, "tyqwer"),
                ItemRowModel(R.drawable.ubuntu, "qert"),
            )
        ) { index, item ->
            MyRow(item = item)
        }
    }
}


@Composable
fun TitleOfBooksScreen(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Книги",
            fontSize = 30.sp
        )

    }
}