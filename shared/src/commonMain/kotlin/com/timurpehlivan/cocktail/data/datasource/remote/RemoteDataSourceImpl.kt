package com.timurpehlivan.cocktail.data.datasource.remote

import com.timurpehlivan.cocktail.data.model.response.ServiceResponseDTO
import com.timurpehlivan.cocktail.data.network.service.CocktailService

class RemoteDataSourceImpl(
    private val cocktailService: CocktailService
) : RemoteDataSource {
    override suspend fun getCocktailList(): Result<ServiceResponseDTO> {
        return cocktailService.getCocktailList()
    }

    override suspend fun getCocktailDetail(cocktailName: String): Result<ServiceResponseDTO> {
        return cocktailService.getCocktailDetail(cocktailName)
    }
}