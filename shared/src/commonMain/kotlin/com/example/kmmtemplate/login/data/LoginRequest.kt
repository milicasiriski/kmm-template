package com.example.kmmtemplate.login.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(var email: String, var password: String)