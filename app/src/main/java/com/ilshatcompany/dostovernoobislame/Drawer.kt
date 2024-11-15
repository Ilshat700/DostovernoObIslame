package com.ilshatcompany.dostovernoobislame

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun Drawer() {
    val items = listOf(
        DrawerItem(Icons.Default.Info, "Об авторе"),
        DrawerItem(Icons.Default.PlayArrow, "Лекции"),
        DrawerItem(Icons.Default.Edit, "Посты"),
        DrawerItem(Icons.Default.DateRange, "Книги"),
        DrawerItem(Icons.Default.ShoppingCart, "Наш магазин"),
        DrawerItem(Icons.Default.Send, "Помощь мусульманам")
    )
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val selectedItem = remember { mutableStateOf(items[0]) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f) // Ограничиваем ширину до 80% экрана
            ) {
                ModalDrawerSheet {
                    Image(
                        painter = painterResource(id = R.drawable.dostoverno_ob_islame),
                        contentDescription = "Header",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    items.forEach { item ->
                        NavigationDrawerItem(
                            modifier = Modifier.padding(10.dp),
                            label = {
                                Text(text = item.title)
                            },
                            selected = selectedItem.value == item,
                            icon = {
                                Icon(
                                    imageVector = item.imageVector,
                                    contentDescription = item.title
                                )
                            },
                            onClick = {
                                scope.launch {
                                    selectedItem.value = item
                                    drawerState.close()
                                }
                            }
                        )
                    }
                }
            }
        },
        content = {

        }
    )
}



data class DrawerItem(
    val imageVector: ImageVector,
    val title: String
)