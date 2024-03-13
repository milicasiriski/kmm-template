package com.example.kmmtemplate.android.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmmtemplate.Greeting
import com.example.kmmtemplate.android.MyApplicationTheme

@Composable
fun GreetingView(
    user: String,
    greeting: Greeting = Greeting()
) {
    Column {
        Text(text = greeting.greet())

        Text(text = "Welcome user $user")
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}