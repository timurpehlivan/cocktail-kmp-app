package com.timurpehlivan.cocktail.domain.usecase

import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.domain.repository.CocktailRepository

class GetSavedCocktailListUseCase(
    private val cocktailRepository: CocktailRepository
) {
    suspend operator fun invoke(): List<Cocktail> {
        return cocktailRepository.getSavedCocktailList()
    }
}