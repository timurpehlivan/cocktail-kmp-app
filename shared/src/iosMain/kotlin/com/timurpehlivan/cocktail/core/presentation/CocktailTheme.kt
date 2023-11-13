package com.timurpehlivan.cocktail.core.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.timurpehlivan.cocktail.presentation.common.theme.DarkColors
import com.timurpehlivan.cocktail.presentation.common.theme.LightColors
import com.timurpehlivan.cocktail.presentation.common.theme.Typography

@Composable
actual fun CocktailTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}