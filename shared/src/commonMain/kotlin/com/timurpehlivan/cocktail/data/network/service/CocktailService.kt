package com.timurpehlivan.cocktail.data.network.service

import com.timurpehlivan.cocktail.data.model.response.ServiceResponseDTO

interface CocktailService {
    suspend fun getCocktailList(): Result<ServiceResponseDTO>
    suspend fun getCocktailDetail(cocktailName: String): Result<ServiceResponseDTO>
}