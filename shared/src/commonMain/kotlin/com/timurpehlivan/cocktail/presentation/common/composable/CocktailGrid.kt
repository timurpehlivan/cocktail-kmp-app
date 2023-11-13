package com.timurpehlivan.cocktail.presentation.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.presentation.common.theme.CustomSize70
import com.timurpehlivan.cocktail.presentation.common.theme.PaddingMedium

@Composable
fun CocktailGrid(
    cocktailList: List<Cocktail>,
    navigateDetail: (Cocktail) -> Unit
) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            top = CustomSize70,
            bottom = CustomSize70,
            start = PaddingMedium,
            end = PaddingMedium,
        )
    ) {
        items(cocktailList) { cocktail ->
            CocktailItem(cocktail, navigateDetail)
        }
    }
}