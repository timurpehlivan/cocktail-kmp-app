package com.timurpehlivan.cocktail.core.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun CocktailTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)