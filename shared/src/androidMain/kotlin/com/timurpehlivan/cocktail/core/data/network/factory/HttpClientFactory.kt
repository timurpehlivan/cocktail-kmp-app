package com.timurpehlivan.cocktail.core.data.network.factory

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android

actual fun createPlatformHttpClient(): HttpClient {
    return HttpClient(Android)
}