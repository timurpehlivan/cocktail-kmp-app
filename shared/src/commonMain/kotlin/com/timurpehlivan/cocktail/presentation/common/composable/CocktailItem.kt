package com.timurpehlivan.cocktail.presentation.common.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.presentation.common.theme.PaddingMedium
import com.timurpehlivan.cocktail.presentation.common.theme.SpaceMedium
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url

@Composable
fun CocktailItem(
    cocktail: Cocktail,
    navigateToDetail: (Cocktail) -> Unit
) {
    val painterResource: Resource<Painter> = asyncPainterResource(data = Url(cocktail.drinkThumb!!))

    Box {
        Column(
            modifier = Modifier
                .clickable { navigateToDetail(cocktail) }
                .padding(PaddingMedium)
        ) {
            KamelImage(
                modifier = Modifier.aspectRatio(1f / 1.2f),
                contentScale = ContentScale.FillHeight,
                resource = painterResource,
                contentDescription = cocktail.name,
                onLoading = { CocktailLoadingSpinner() }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = cocktail.name!!,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}