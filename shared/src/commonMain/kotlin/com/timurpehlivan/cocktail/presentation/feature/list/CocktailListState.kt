package com.timurpehlivan.cocktail.presentation.feature.list

import androidx.compose.runtime.Immutable
import com.timurpehlivan.cocktail.domain.model.Cocktail

@Immutable
internal data class CocktailListState(
    val cocktailList: List<Cocktail>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)