package com.timurpehlivan.cocktail.presentation.feature.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailBottomAppBar
import com.timurpehlivan.cocktail.presentation.feature.list.composable.CocktailListContent
import com.timurpehlivan.cocktail.presentation.feature.list.composable.CocktailListTopBar
import org.koin.compose.koinInject

class CocktailListScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinInject<CocktailListViewModel>()
        val state by viewModel.state.collectAsState()

        Scaffold(
            topBar = { CocktailListTopBar(viewModel) },
            bottomBar = { CocktailBottomAppBar() },
            content = { CocktailListContent(viewModel, state) }
        )
    }
}