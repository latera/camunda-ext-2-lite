package com.hydra_billing.camunda.api.hydra.rest.v2

import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class Login(val client: HttpClient) {
    data class LoginParams(val login: String, val password: String, val appCode: String? = null)

    data class LoginResponse(val session: Session, val navigation: Navigation)

    data class Session(val token: String)

    data class Navigation(val self: String)

    fun login(params: LoginParams): Session {
        val client = this.client

        val response = runBlocking {
            client.post<LoginResponse> {
                url { encodedPath = "/rest/v2/login" }

                body = mapOf("session" to params)
            }
        }

        return response.session
    }
}
