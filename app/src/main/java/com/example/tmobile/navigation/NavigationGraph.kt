package com.example.tmobile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tmobile.activity.DetailsScreen
import com.example.tmobile.activity.ListScreen
import com.example.tmobile.activity.OnboardingScreen
import com.example.tmobile.navigation.Navigation.Route.ROUTE_FIRST_SCREEN
import com.example.tmobile.navigation.Navigation.Route.ROUTE_SPLASH_SCREEN

fun NavGraphBuilder.navigationGraph(
    navController: NavController,
    actions: Actions
) {

    navigation(
        startDestination = ROUTE_SPLASH_SCREEN,
        route = Navigation.Path.SPLASH_SCREEN

    ) {
        onBoardingScreen(navController)
        firstScreen(navController)
        secondScreen()
    }
}

    fun NavGraphBuilder.firstScreen(navController: NavController){
        composable(route = ROUTE_FIRST_SCREEN) {
            ListScreen("Nisha Hello", buttonClick = {

                navController.navigate(Navigation.Path.SECOND_SCREEN)
            })
        }
    }
fun NavGraphBuilder.onBoardingScreen(){
        composable(route = ROUTE_SPLASH_SCREEN) {
            OnboardingScreen(valid = true)
        }
    }
fun NavGraphBuilder.secondScreen(){
        composable(route = Navigation.Path.SECOND_SCREEN) {
            DetailsScreen("Nisha HelloBBB")
        }
    }
