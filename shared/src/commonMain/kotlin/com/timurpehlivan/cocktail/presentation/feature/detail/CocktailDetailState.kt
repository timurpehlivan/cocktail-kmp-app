package com.timurpehlivan.cocktail.presentation.feature.detail

import androidx.compose.runtime.Immutable
import com.timurpehlivan.cocktail.domain.model.Cocktail

@Immutable
internal data class CocktailDetailState(
    val cocktail: Cocktail? = null,
    val isSaved: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null
)