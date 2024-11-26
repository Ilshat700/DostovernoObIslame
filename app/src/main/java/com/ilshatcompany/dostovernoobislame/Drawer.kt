
package com.ilshatcompany.dostovernoobislame

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AppDrawer(
    navController: NavHostController, closeDrawer: () -> Unit) {
    val items = listOf(
        DrawerItem(Icons.Default.Info, "Об авторе", "about"),
        DrawerItem(Icons.Default.PlayArrow, "Лекции", "lectures"),
        DrawerItem(Icons.Default.Edit, "Посты", "posts"),
        DrawerItem(Icons.Default.DateRange, "Книги", "books"),
        DrawerItem(Icons.Default.ShoppingCart, "Наш магазин", "shop"),
        DrawerItem(Icons.Default.Send, "Помощь мусульманам", "help"),
        DrawerItem(Icons.Default.Warning, "Важные правила", "rules")
    )

    ModalDrawerSheet(
        modifier = Modifier.fillMaxWidth(0.8f)
    ) {
        items.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item.title) },
                selected = false,
                icon = {
                    Icon(imageVector = item.imageVector, contentDescription = item.title)
                },
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                    }
                    closeDrawer()
                },
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

// Класс данных для кнопок меню
data class DrawerItem(
    val imageVector: ImageVector,
    val title: String,
    val route: String
)
