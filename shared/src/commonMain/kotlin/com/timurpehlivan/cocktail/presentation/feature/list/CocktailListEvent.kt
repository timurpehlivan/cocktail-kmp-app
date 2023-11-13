package com.timurpehlivan.cocktail.presentation.feature.list

internal sealed interface CocktailListEvent {
    data object GetCocktailList : CocktailListEvent
}