package com.example.tmobile.presentations.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tmobile.presentations.component.DetailsScreen
import com.example.tmobile.presentations.component.ListScreen
import com.example.tmobile.presentations.component.OnboardingScreen
import com.example.tmobile.presentations.component.SignInScreen
import com.example.tmobile.presentations.navigation.Navigation.Route.ROUTE_SPLASH_SCREEN
import com.example.tmobile.presentations.navigation.Navigation.Route.SPLASH_SCREEN

fun NavGraphBuilder.navigationGraph(
    navController: NavController,
    actions: Actions
) {
    navigation(
        startDestination = ROUTE_SPLASH_SCREEN,
        route = SPLASH_SCREEN
    ) {
        onBoardingScreen(navController)
        firstScreen(navController)
        secondScreen()
        signInScreen(navController)
    }
}

fun NavGraphBuilder.firstScreen(navController: NavController) {
    composable(route = Navigation.Path.FIRST_SCREEN) {
        ListScreen("Nisha Hello", buttonClick = {
            navController.navigate(Navigation.Path.SECOND_SCREEN)
        })
    }
}

fun NavGraphBuilder.onBoardingScreen(navController: NavController) {
    composable(route = ROUTE_SPLASH_SCREEN) {
        OnboardingScreen(
            valid = true,
            onSplashEndedValid = {
                navController.navigate(Navigation.Path.SIGN_IN_SCREEN)
                { popUpTo(SPLASH_SCREEN) { inclusive = true } }
            })
    }
}

fun NavGraphBuilder.secondScreen() {
    composable(route = Navigation.Path.SECOND_SCREEN) {
        DetailsScreen("Nisha HelloBBB")
    }
}


fun NavGraphBuilder.signInScreen(navController: NavController) {
    composable(route = Navigation.Path.SIGN_IN_SCREEN) {
        SignInScreen(signInButtonClick = {
            navController.navigate(Navigation.Path.FIRST_SCREEN)
        })
    }
}