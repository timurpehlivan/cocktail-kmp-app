package com.timurpehlivan.cocktail.presentation.feature.list.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailError
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailGrid
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailLoadingSpinner
import com.timurpehlivan.cocktail.presentation.feature.detail.CocktailDetailScreen
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListEvent
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListEvent.*
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListState
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListViewModel

@Composable
internal fun CocktailListContent(
    viewModel: CocktailListViewModel,
    state: CocktailListState
) {
    val navigator = LocalNavigator.currentOrThrow

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) CocktailLoadingSpinner()
        state.cocktailList?.let {
            CocktailGrid(
                state.cocktailList
            ) { navigator.push(CocktailDetailScreen(cocktail = it)) }
        }
        state.error?.let {
            CocktailError(
                state.error,
                onClick = {
                    viewModel.onEvent(GetCocktailList)
                }
            )
        }
    }
}