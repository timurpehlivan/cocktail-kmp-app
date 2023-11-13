package com.timurpehlivan.cocktail.presentation.feature.saved

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailBottomAppBar
import com.timurpehlivan.cocktail.presentation.feature.saved.composable.SavedCocktailListContent
import com.timurpehlivan.cocktail.presentation.feature.saved.composable.SavedCocktailListTopBar
import org.koin.compose.koinInject

class SavedCocktailListScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinInject<SavedCocktailListViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.onEvent(SavedCocktailListEvent.GetSavedCocktailList)
        }

        Scaffold(
            topBar = { SavedCocktailListTopBar() },
            bottomBar = { CocktailBottomAppBar() },
            content = { SavedCocktailListContent(state) }
        )
    }
}