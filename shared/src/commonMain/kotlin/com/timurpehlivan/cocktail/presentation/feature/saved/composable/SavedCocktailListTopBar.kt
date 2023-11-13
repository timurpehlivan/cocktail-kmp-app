package com.timurpehlivan.cocktail.presentation.feature.saved.composable

import CocktailTopAppBar
import androidx.compose.runtime.Composable
import com.timurpehlivan.cocktail.util.StringResources

@Composable
internal fun SavedCocktailListTopBar() {
    CocktailTopAppBar(title = StringResources.SAVED_COCKTAIL_LIST_SCREEN_TITLE)
}