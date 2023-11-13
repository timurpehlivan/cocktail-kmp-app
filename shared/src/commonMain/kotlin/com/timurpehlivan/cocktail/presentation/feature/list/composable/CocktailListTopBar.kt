package com.timurpehlivan.cocktail.presentation.feature.list.composable

import CocktailTopAppBar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.timurpehlivan.cocktail.presentation.common.theme.PaddingLarge
import com.timurpehlivan.cocktail.presentation.common.theme.SizeLarge
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListEvent
import com.timurpehlivan.cocktail.presentation.feature.list.CocktailListViewModel
import com.timurpehlivan.cocktail.util.StringResources

@Composable
internal fun CocktailListTopBar(
    viewModel: CocktailListViewModel
) {
    CocktailTopAppBar(
        title = StringResources.COCKTAIL_LIST_SCREEN_TITLE,
        actions = {
            Row {
                Icon(
                    modifier = Modifier
                        .clickable { viewModel.onEvent(CocktailListEvent.GetCocktailList) }
                        .padding(end = PaddingLarge)
                        .size(SizeLarge),
                    imageVector = Icons.Default.Refresh,
                    contentDescription = StringResources.REFRESH_BUTTON_DESC,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    )
}