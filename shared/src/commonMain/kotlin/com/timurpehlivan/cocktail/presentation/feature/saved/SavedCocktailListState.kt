package com.timurpehlivan.cocktail.presentation.feature.saved

import androidx.compose.runtime.Immutable
import com.timurpehlivan.cocktail.domain.model.Cocktail

@Immutable
internal data class SavedCocktailListState(
    val cocktailList: List<Cocktail>? = null,
    val isLoading: Boolean = false
)