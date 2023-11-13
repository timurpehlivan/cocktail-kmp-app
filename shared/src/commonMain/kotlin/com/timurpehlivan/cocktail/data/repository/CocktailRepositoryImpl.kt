package com.timurpehlivan.cocktail.data.repository

import com.timurpehlivan.cocktail.data.datasource.local.LocalDataSource
import com.timurpehlivan.cocktail.data.datasource.remote.RemoteDataSource
import com.timurpehlivan.cocktail.data.mapper.toDomain
import com.timurpehlivan.cocktail.data.mapper.toEntity
import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class CocktailRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : CocktailRepository {
    override suspend fun getCocktailList(): Result<List<Cocktail>> {
        return remoteDataSource.getCocktailList().map {
            it.cocktails?.map { cocktailDTO -> cocktailDTO.toDomain() } ?: emptyList()
        }
    }

    override suspend fun getCocktailDetail(cocktailName: String): Result<List<Cocktail>> {
        return remoteDataSource.getCocktailDetail(cocktailName).map {
            it.cocktails?.map { cocktailDTO -> cocktailDTO.toDomain() } ?: emptyList()
        }
    }

    override suspend fun saveCocktail(cocktail: Cocktail) {
        localDataSource.saveCocktail(cocktail.toEntity())
    }

    override suspend fun deleteCocktail(cocktailId: Long) {
        localDataSource.deleteCocktail(cocktailId)
    }

    override suspend fun getSavedCocktailList(): List<Cocktail> {
        return localDataSource.getSavedCocktailList().map {
            it.toDomain()
        }
    }

    override suspend fun checkCocktailSaved(cocktailId: Long): Boolean {
        return localDataSource.checkCocktailSaved(cocktailId)
    }
}