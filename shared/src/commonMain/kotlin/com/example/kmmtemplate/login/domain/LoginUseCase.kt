package com.example.kmmtemplate.login.domain

import com.example.kmmtemplate.data.local.LocalStorage
import com.example.kmmtemplate.util.Either
import com.example.kmmtemplate.util.left
import com.example.kmmtemplate.util.right

class LoginUseCase(
    private val accountService: AccountService,
    private val localStorage: LocalStorage
) {
    suspend fun invoke(email: String, password: String): Either<LoginUseCaseError, Unit> {
        val credentials = LoginCredentials(email, password)
        val result = accountService.login(credentials = credentials)
        when (result) {
            is Either.Right -> {
                localStorage.saveUser(result.value)
                return Unit.right()
            }

            is Either.Left -> {
                return LoginUseCaseError.left()
            }
        }
    }
}

object LoginUseCaseError