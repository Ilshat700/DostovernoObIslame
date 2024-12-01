package com.ilshatcompany.dostovernoobislame

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostsScreen() {
    // Контент страницы "Посты"

    TitleOfPostsScreen()

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
        ListItem(name = "qwerty", profession = "asdffg")
    }

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
private fun ListItem(name: String, profession: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                Log.d("MyLog", "Clicked")
            },
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.dostoverno_ob_islame512),
                    contentDescription = "image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = name)
                    Text(text = profession)
                }
            }
        }

    }
}