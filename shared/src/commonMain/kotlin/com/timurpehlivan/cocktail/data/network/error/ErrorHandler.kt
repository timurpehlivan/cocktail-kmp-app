package com.timurpehlivan.cocktail.data.network.error

import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess

suspend inline fun <reified T> safeRequest(block: () -> HttpResponse): Result<T> {
    try {
        val response = block()
        return if (response.status.isSuccess()) {
            Result.success(response.call.body())
        } else {
            val errorResult = when (response.status) {
                HttpStatusCode.NotFound -> "Resource not found"
                HttpStatusCode.BadRequest -> "Bad request"
                else -> response.status.description
            }
            return Result.failure(Exception(errorResult))
        }
    } catch (e: Exception) {
        val errorMessage = when (e) {
            is ClientRequestException -> "Bad request: ${e.message}"
            is ServerResponseException -> "Server error: ${e.message}"
            else -> "Network error: ${e.message}"
        }
        return Result.failure(Exception(errorMessage))
    }
}