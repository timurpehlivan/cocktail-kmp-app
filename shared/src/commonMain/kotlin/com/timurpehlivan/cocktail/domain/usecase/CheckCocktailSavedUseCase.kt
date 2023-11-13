package com.timurpehlivan.cocktail.domain.usecase

import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class CheckCocktailSavedUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend operator fun invoke(cocktailId: Long): Boolean {
        return cocktailRepository.checkCocktailSaved(cocktailId)
    }
}