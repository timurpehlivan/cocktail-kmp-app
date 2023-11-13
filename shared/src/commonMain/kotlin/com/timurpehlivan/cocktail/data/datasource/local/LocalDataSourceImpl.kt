package com.timurpehlivan.cocktail.data.datasource.local

import com.timurpehlivan.cocktail.data.database.dao.CocktailDao
import database.CocktailEntity

class LocalDataSourceImpl(
    private val cocktailDao: CocktailDao
) : LocalDataSource {
    override suspend fun saveCocktail(cocktail: CocktailEntity) {
        cocktailDao.saveCocktail(cocktail)
    }

    override suspend fun deleteCocktail(cocktailId: Long) {
        cocktailDao.deleteCocktail(cocktailId)
    }

    override suspend fun getSavedCocktailList(): List<CocktailEntity> {
        return cocktailDao.savedCocktailList()
    }

    override suspend fun checkCocktailSaved(cocktailId: Long): Boolean {
        return cocktailDao.checkCocktailSaved(cocktailId)
    }
}