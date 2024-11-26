package com.ilshatcompany.dostovernoobislame


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//
//
//
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//
//            WelcomeScreen()
//            Drawer()
//
//        }
//    }
//}
//

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

// Screens import

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppWithNavigation()
        }
    }
}

@Composable
fun AppWithNavigation() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                navController = navController,
                closeDrawer = { scope.launch { drawerState.close() } }
            )
        }
    ) {
        NavHostContainer(
            navController = navController,
            openDrawer = { scope.launch { drawerState.open() } })
    }
}

@Composable
fun NavHostController.AppDrawer(closeDrawer: () -> Unit) {
    val items = listOf(
        DrawerItem(Icons.Default.Info, "Об авторе", "about"),
        DrawerItem(Icons.Default.PlayArrow, "Лекции", "lectures"),
        DrawerItem(Icons.Default.Edit, "Посты", "posts"),
        DrawerItem(Icons.Default.DateRange, "Книги", "books"),
        DrawerItem(Icons.Default.ShoppingCart, "Наш магазин", "shop"),
        DrawerItem(Icons.Default.Send, "Помощь мусульманам", "help"),
        DrawerItem(Icons.Default.Warning, "Важные правила", "rules"),
        DrawerItem(Icons.Default.ExitToApp, "Страница регистрации", "registration")
    )

    ModalDrawerSheet {
        items.forEach { item ->
            NavigationDrawerItem(
                label = { Text(item.title) },
                selected = false,
                icon = {
                    Icon(imageVector = item.imageVector, contentDescription = item.title)
                },
                onClick = {
                    navigate(item.route) {
                        launchSingleTop = true
                    }
                    closeDrawer()
                },
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavHostContainer(navController: NavHostController, openDrawer: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Достоверно об Исламе") },
                navigationIcon = {
                    IconButton(onClick = openDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Меню")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = "rules"
            ) {
                composable("about") { AboutScreen() }
                composable("lectures") { LecturesScreen() }
                composable("posts") { PostsScreen() }
                composable("books") { BooksScreen() }
                composable("shop") { ShopScreen() }
                composable("help") { HelpScreen() }
                composable("rules") { RulesScreen() }
                composable("registration") { RegistrationScreen() }
            }
        }
    }
}


