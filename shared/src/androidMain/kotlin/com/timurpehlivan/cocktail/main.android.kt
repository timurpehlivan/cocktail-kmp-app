package com.timurpehlivan.cocktail

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.timurpehlivan.cocktail.presentation.App

@Composable
fun MainView() = App(
    darkTheme = isSystemInDarkTheme(),
    dynamicColor = true
)