package com.timurpehlivan.cocktail.data.datasource.local

import database.CocktailEntity

interface LocalDataSource {
    suspend fun saveCocktail(cocktail: CocktailEntity)
    suspend fun deleteCocktail(cocktailId: Long)
    suspend fun getSavedCocktailList(): List<CocktailEntity>
    suspend fun checkCocktailSaved(cocktailId: Long): Boolean
}