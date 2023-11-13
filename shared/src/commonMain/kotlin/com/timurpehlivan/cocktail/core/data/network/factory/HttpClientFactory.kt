package com.timurpehlivan.cocktail.core.data.network.factory

import io.ktor.client.HttpClient

expect fun createPlatformHttpClient(): HttpClient