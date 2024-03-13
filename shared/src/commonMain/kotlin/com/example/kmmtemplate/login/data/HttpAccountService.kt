package com.example.kmmtemplate.login.data

import com.example.kmmtemplate.data.KtorClient
import com.example.kmmtemplate.login.domain.AccountService
import com.example.kmmtemplate.login.domain.AccountServiceError
import com.example.kmmtemplate.login.domain.LoginCredentials
import com.example.kmmtemplate.util.Either
import com.example.kmmtemplate.util.left
import com.example.kmmtemplate.util.right
import io.ktor.http.HttpStatusCode

class HttpAccountService(private val client: KtorClient) : AccountService {
    private val servicePath = "account"

    override suspend fun login(credentials: LoginCredentials): Either<AccountServiceError, String> {
        val result = client.post("$servicePath/login", credentials.body())
        return when (result.status) {
            HttpStatusCode.OK -> credentials.email.right()
            else -> AccountServiceError.LoginFailed.left()
        }
    }
}