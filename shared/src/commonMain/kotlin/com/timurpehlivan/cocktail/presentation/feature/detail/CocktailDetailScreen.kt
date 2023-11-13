package com.timurpehlivan.cocktail.presentation.feature.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.presentation.feature.detail.composable.CocktailDetailContent
import com.timurpehlivan.cocktail.presentation.feature.detail.composable.CocktailDetailTopBar
import org.koin.compose.koinInject

class CocktailDetailScreen(
    private val cocktail: Cocktail
) : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinInject<CocktailDetailViewModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.onEvent(CocktailDetailEvent.GetCocktailDetail(cocktail))
        }

        Scaffold(
            topBar = { CocktailDetailTopBar() },
            content = { CocktailDetailContent(viewModel, state, cocktail) }
        )
    }
}