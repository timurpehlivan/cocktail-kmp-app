package com.timurpehlivan.cocktail.presentation.common.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.timurpehlivan.cocktail.presentation.common.theme.CustomSize100

@Composable
fun CocktailLoadingSpinner(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(CustomSize100),
            color = MaterialTheme.colorScheme.primary
        )
    }
}