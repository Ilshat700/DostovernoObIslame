package com.ilshatcompany.dostovernoobislame

import android.media.AudioTrack
import android.media.MediaPlayer
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.unit.sp


@Composable
fun LecturesScreen() {

    TitleOfLecturesScreen()

    LazyColumn {
        items(20) {
            Audio1()
        }
    }

}


@Composable
fun TitleOfLecturesScreen(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Лекции",
            fontSize = 20.sp
        )

    }
}


@Composable
fun Audio1() {

    val context = LocalContext.current
    var isPlaying by remember { mutableStateOf(false) }

    // Создаём MediaPlayer
    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.detyam_ob_ispytaniyah) // Укажите имя вашего файла
    }

    // Освобождаем ресурсы MediaPlayer, чтобы не было утечек
    DisposableEffect(Unit) {
        onDispose {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            mediaPlayer.release()
        }
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(text = "Детям об испытаниях")

                Row {
                    Button(
                        onClick = {
                            if (isPlaying) {
                                mediaPlayer.pause()
                            } else {
                                mediaPlayer.start()
                            }
                            isPlaying = !isPlaying
                        }
                    ) {
                        Text(text = if (isPlaying) "Pause" else "Play")
                    }

                    Spacer(modifier = Modifier.width(15.dp))

                    Button(
                        onClick = {
                            mediaPlayer.stop()
                            mediaPlayer.prepare() // Подготовка для повторного воспроизведения
                            isPlaying = false
                        }
                    ) {
                        Text(text = "Stop")
                    }
                }

            }
        }
    }

}
