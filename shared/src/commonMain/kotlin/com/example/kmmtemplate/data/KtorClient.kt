package com.example.kmmtemplate.data

import io.ktor.client.*
import io.ktor.client.plugins.auth.*
import io.ktor.client.plugins.auth.providers.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorClient {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }

        install(Auth) {
            bearer {
                loadTokens {
                    // TODO: Get access and refresh tokens
                    BearerTokens("access-token", "refresh-token")
                }
                refreshTokens {
                    // TODO: Implement refresh token code
                    BearerTokens("new-access-token", "new-refresh-token")
                }
            }
        }
    }

    suspend fun get(path: String): HttpResponse =
        client.request("https://example.com/api/$path") {
            contentType(ContentType.Application.Json)
            accept(ContentType.Any)
            method = HttpMethod.Get
        }

    suspend inline fun <reified T> post(path: String, body: T) =
        client.request("https://example.com/api/$path") {
            contentType(ContentType.Application.Json)
            accept(ContentType.Any)
            setBody(body)
            method = HttpMethod.Post
        }

    suspend inline fun post(path: String) =
        client.request("https://example.com/api/$path") {
            contentType(ContentType.Application.Json)
            accept(ContentType.Any)
            method = HttpMethod.Post
        }
}