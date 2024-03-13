package com.example.kmmtemplate.login.data

import com.example.kmmtemplate.login.domain.AccountService
import com.example.kmmtemplate.login.domain.AccountServiceError
import com.example.kmmtemplate.login.domain.LoginCredentials
import com.example.kmmtemplate.util.Either
import com.example.kmmtemplate.util.left
import com.example.kmmtemplate.util.right

class MockAccountService : AccountService {
    override suspend fun login(credentials: LoginCredentials): Either<AccountServiceError, String> {
        return if (credentials.email == "user@email.com" && credentials.password == "password") {
            credentials.email.right()
        } else {
            AccountServiceError.LoginFailed.left()
        }
    }
}