package com.example.kmmtemplate.login.data

import com.example.kmmtemplate.login.domain.LoginCredentials

fun LoginCredentials.body() = LoginRequest(email = email, password = password)