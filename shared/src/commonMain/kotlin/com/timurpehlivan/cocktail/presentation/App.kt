package com.timurpehlivan.cocktail.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.timurpehlivan.cocktail.core.presentation.CocktailTheme
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListScreen

@Composable
internal fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean
) {
    CocktailTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Navigator(
            CocktailListScreen()
        )
    }
}