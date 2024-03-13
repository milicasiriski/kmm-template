package com.example.kmmtemplate.login.domain

import com.example.kmmtemplate.util.Either

interface AccountService {
    suspend fun login(credentials: LoginCredentials): Either<AccountServiceError, String>
}

sealed interface AccountServiceError {
    data object LoginFailed : AccountServiceError
}