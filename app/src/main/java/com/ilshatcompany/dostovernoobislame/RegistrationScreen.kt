package com.ilshatcompany.dostovernoobislame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen() {

    TitleOfRegistrationScreen()

}



@Composable
fun TitleOfRegistrationScreen(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Страница регистрации",
            fontSize = 20.sp
        )

    }
}
