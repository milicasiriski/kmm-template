package com.example.kmmtemplate.android.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.kmmtemplate.Greeting
import com.example.kmmtemplate.android.home.views.GreetingView
import com.example.kmmtemplate.android.navigation.camera
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    onBackPressed: () -> Unit,
    viewModel: HomeViewModel = getViewModel()
) {
    BackHandler {
        onBackPressed()
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        GreetingView(user = viewModel.user.value)

        Button(onClick = navController::camera) {
            Text(text = "Open camera screen")
        }
    }
}