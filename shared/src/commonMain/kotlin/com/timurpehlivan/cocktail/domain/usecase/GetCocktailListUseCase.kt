package com.timurpehlivan.cocktail.domain.usecase

import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class GetCocktailListUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend operator fun invoke(): Result<List<Cocktail>> {
        return cocktailRepository.getCocktailList()
    }
}