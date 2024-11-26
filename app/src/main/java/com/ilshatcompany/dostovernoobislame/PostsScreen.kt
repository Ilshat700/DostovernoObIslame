package com.ilshatcompany.dostovernoobislame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostsScreen() {
    // Контент страницы "Посты"

    TitleOfPostsScreen()

    ListItem(name = "", prof = "")
}


@Composable
fun TitleOfPostsScreen(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Посты",
            fontSize = 20.sp
        )
    }
}


@Composable
private fun ListItem(name: String, prof: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.dostoverno_ob_islame512),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(5.dp).size(64.dp).clip(CircleShape)
                )
            }
        }

    }
}