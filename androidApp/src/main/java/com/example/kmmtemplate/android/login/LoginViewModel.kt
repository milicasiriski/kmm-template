package com.example.kmmtemplate.android.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmtemplate.login.domain.LoginUseCase
import com.example.kmmtemplate.util.Either
import kotlinx.coroutines.launch

class LoginViewModel(private val login: LoginUseCase) : ViewModel() {
    // We don't need to encapsulate fields that can be changed from the view
    // E.g. text field values
    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")

    // State value encapsulation:
    // A private mutable state with initial value
    // A public immutable state holding a reference to the private mutable state
    // State can change inside the view model but not in the view
    private val _error: MutableState<String?> = mutableStateOf(null)
    val error: State<String?> = _error

    private val _loading: MutableState<Boolean> = mutableStateOf(false)
    val loading: State<Boolean> = mutableStateOf(false)

    fun login(onSuccess: () -> Unit) {
        _loading.value = true

        viewModelScope.launch {
            if (email.value.isBlank() || password.value.isBlank()) {
                _error.value = "Email and password cannot be empty"
                _loading.value = false
                return@launch
            }

            val result = login.invoke(email = email.value, password = password.value)

            if (result is Either.Right) {
                _error.value = null
                onSuccess()
            } else {
                _error.value = "Invalid credentials"
            }
        }

        _loading.value = false
    }
}