package com.timurpehlivan.cocktail.presentation.common.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.timurpehlivan.cocktail.presentation.common.theme.PaddingLarge
import com.timurpehlivan.cocktail.presentation.common.theme.SpaceLarge
import com.timurpehlivan.cocktail.util.StringResources

@Composable
fun CocktailError(
    error: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(horizontal = PaddingLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.size(SpaceLarge))
        Button(onClick = onClick) {
            Text(text = StringResources.TRY_AGAIN_BUTTON_TEXT)
        }
    }
}