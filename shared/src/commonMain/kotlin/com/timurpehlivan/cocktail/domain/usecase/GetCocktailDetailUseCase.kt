package com.timurpehlivan.cocktail.domain.usecase

import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class GetCocktailDetailUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend operator fun invoke(cocktailName: String): Result<List<Cocktail>> {
        return cocktailRepository.getCocktailDetail(cocktailName)
    }
}