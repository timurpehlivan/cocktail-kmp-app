package com.timurpehlivan.cocktail.domain.usecase

import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class DeleteCocktailUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend operator fun invoke(cocktailId: Long) {
        cocktailRepository.deleteCocktail(cocktailId)
    }
}