package com.timurpehlivan.cocktail.presentation.feature.saved

internal sealed interface SavedCocktailListEvent {
    data object GetSavedCocktailList : SavedCocktailListEvent
}