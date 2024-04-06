package com.example.kmmtemplate.android.navigation

import androidx.navigation.NavController

object Routes {
    const val login = "login"
    const val home = "home"
    const val camera = "camera"
}

// Kotlin support extension functions
// That is creating functions for existing classes
// that apply only in your project or library
fun NavController.login() {
    navigate(Routes.login)
}

fun NavController.home() {
    navigate(Routes.home)
}

fun NavController.camera() {
    navigate(Routes.camera)
}