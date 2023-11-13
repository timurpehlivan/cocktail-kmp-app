package com.timurpehlivan.cocktail.data.database.dao

import com.timurpehlivan.cocktail.CocktailDatabase
import database.CocktailEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class CocktailDao(
    private val cocktailDatabase: CocktailDatabase
) {
    private val query get() = cocktailDatabase.cocktailQueries

    suspend fun saveCocktail(cocktail: CocktailEntity) {
        withContext(Dispatchers.IO) {
            query.saveCocktail(cocktail)
        }
    }

    suspend fun deleteCocktail(cocktailId: Long) {
        withContext(Dispatchers.IO) {
            query.deleteCocktail(cocktailId)
        }
    }

    suspend fun savedCocktailList(): List<CocktailEntity> {
        return withContext(Dispatchers.IO) {
            query.getSavedCocktailList().executeAsList()
        }
    }

    suspend fun checkCocktailSaved(cocktailId: Long): Boolean {
        return withContext(Dispatchers.IO) {
            query.checkCocktailSaved(cocktailId).executeAsOne()
        }
    }
}