package com.timurpehlivan.cocktail.domain.usecase

import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class SaveCocktailUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend operator fun invoke(cocktail: Cocktail) {
        return cocktailRepository.saveCocktail(cocktail)
    }
}