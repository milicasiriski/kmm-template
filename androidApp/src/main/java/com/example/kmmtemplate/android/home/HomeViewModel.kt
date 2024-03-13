package com.example.kmmtemplate.android.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.kmmtemplate.data.local.LocalStorage

class HomeViewModel(localStorage: LocalStorage) : ViewModel() {
    private val _user: MutableState<String> = mutableStateOf("")
    val user: State<String> = _user

    // Kotlin constructor
    init {
        // Kotlin null-check
        localStorage.getUser()?.let {
            _user.value = it
        }

//        // Alternative code
//        val nullableUser: String? = localStorage.getUser()
//        if (nullableUser != null) {
//            // Notice that nullable user (String?) is automatically cast to String (not-null)
//            _user.value = nullableUser
//        }

//        // Or using the Elvis operator ?:
//        _user.value = localStorage.getUser() ?: "default value"
    }
}