package com.example.kmmtemplate.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kmmtemplate.android.home.HomeScreen
import com.example.kmmtemplate.android.login.LoginScreen

@Composable
fun Navigation(
    navController: NavHostController,
    finish: () -> Unit
) {
    NavHost(navController = navController, startDestination = Routes.login) {
        composable(Routes.login) {
            LoginScreen(
                navController = navController
            )
        }

        composable(Routes.home) {
            HomeScreen(
                navController = navController,
                onBackPressed = finish
            )
        }
    }
}