package com.timurpehlivan.cocktail.domain.repository

import com.timurpehlivan.cocktail.domain.model.Cocktail

interface CocktailRepository {
    suspend fun getCocktailList(): Result<List<Cocktail>>
    suspend fun getCocktailDetail(cocktailName: String): Result<List<Cocktail>>
    suspend fun saveCocktail(cocktail: Cocktail)
    suspend fun deleteCocktail(cocktailId: Long)
    suspend fun getSavedCocktailList(): List<Cocktail>
    suspend fun checkCocktailSaved(cocktailId: Long): Boolean
}