package com.timurpehlivan.cocktail.presentation.feature.detail.composable

import CocktailTopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.timurpehlivan.cocktail.util.StringResources

@Composable
internal fun CocktailDetailTopBar() {
    val navigator = LocalNavigator.currentOrThrow

    CocktailTopAppBar(
        title = StringResources.COCKTAIL_DETAIL_SCREEN_TITLE,
        navigationIcon = Icons.Filled.ArrowBack,
        onNavigationClick = {
            navigator.pop()
        }
    )
}