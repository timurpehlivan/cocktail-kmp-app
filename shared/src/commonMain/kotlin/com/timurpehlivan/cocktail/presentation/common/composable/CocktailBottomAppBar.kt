package com.timurpehlivan.cocktail.presentation.common.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.timurpehlivan.cocktail.presentation.common.theme.CustomSize60
import com.timurpehlivan.cocktail.presentation.common.theme.SizeLarge
import com.timurpehlivan.cocktail.presentation.feature.saved.SavedCocktailListScreen
import com.timurpehlivan.cocktail.util.StringResources

@Composable
fun CocktailBottomAppBar() {
    val navigator = LocalNavigator.currentOrThrow

    BottomAppBar(
        modifier = Modifier.height(CustomSize60),
        containerColor = MaterialTheme.colorScheme.secondary,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomAppBarIcon(
                    onClick = { if (navigator.size != 1) navigator.pop() },
                    imageVector = if (navigator.size == 1) Icons.Filled.Home else Icons.Outlined.Home,
                    contentDescription = StringResources.COCKTAIL_LIST_MENU_DESC,
                )
                BottomAppBarIcon(
                    onClick = { if (navigator.size != 2) navigator.push(SavedCocktailListScreen()) },
                    imageVector = if (navigator.size == 2) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder,
                    contentDescription = StringResources.SAVED_COCKTAIL_LIST_MENU_DESC,
                )
            }
        }
    )
}

@Composable
fun BottomAppBarIcon(
    onClick: () -> Unit,
    imageVector: ImageVector,
    contentDescription: String,
) {
    IconButton(
        onClick = onClick,
        content = {
            Icon(
                modifier = Modifier.size(SizeLarge),
                imageVector = imageVector,
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.secondaryContainer,
            )
        }
    )
}