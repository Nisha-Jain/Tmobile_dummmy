package com.example.tmobile.presentations.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

class Actions(navController: NavController) {
    val navigateToSecond: () -> Unit = {
        navController.navigate(Navigation.Path.SECOND_SCREEN)
    }
}

@Composable
fun NavigationNavHost(
    navHostController: NavHostController,
    ) {
    val action = remember { Actions(navHostController) }
    NavHost(
        navController = navHostController,
        startDestination = Navigation.Path.SPLASH_SCREEN, modifier = Modifier.padding(5.dp),
    ) {
        navigationGraph(navHostController, actions = action)
    }
}

