package com.timurpehlivan.cocktail.presentation.feature.detail

import com.timurpehlivan.cocktail.domain.model.Cocktail

internal sealed interface CocktailDetailEvent {
    data class GetCocktailDetail(val cocktail: Cocktail) : CocktailDetailEvent
    data class OnButtonClicked(val cocktail: Cocktail) : CocktailDetailEvent
}