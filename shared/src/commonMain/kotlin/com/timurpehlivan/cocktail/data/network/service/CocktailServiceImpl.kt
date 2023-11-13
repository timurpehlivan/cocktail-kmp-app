package com.timurpehlivan.cocktail.data.network.service

import com.timurpehlivan.cocktail.data.model.response.ServiceResponseDTO
import com.timurpehlivan.cocktail.data.network.error.safeRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class CocktailServiceImpl(
    private val httpClient: HttpClient
) : CocktailService {
    override suspend fun getCocktailList(): Result<ServiceResponseDTO> {
        return safeRequest {
            httpClient.get("filter.php?c=Cocktail")
        }
    }

    override suspend fun getCocktailDetail(cocktailName: String): Result<ServiceResponseDTO> {
        return safeRequest {
            httpClient.get("search.php?s=$cocktailName")
        }
    }
}