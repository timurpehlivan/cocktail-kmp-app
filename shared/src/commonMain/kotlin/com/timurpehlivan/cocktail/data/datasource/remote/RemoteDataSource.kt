package com.timurpehlivan.cocktail.data.datasource.remote

import com.timurpehlivan.cocktail.data.model.response.ServiceResponseDTO

interface RemoteDataSource {
    suspend fun getCocktailList(): Result<ServiceResponseDTO>
    suspend fun getCocktailDetail(cocktailName: String): Result<ServiceResponseDTO>
}