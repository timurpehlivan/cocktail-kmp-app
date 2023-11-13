package com.timurpehlivan.cocktail.presentation.feature.detail.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.timurpehlivan.cocktail.domain.model.Cocktail
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailError
import com.timurpehlivan.cocktail.presentation.common.composable.CocktailLoadingSpinner
import com.timurpehlivan.cocktail.presentation.common.theme.CustomSize200
import com.timurpehlivan.cocktail.presentation.common.theme.CustomSize60
import com.timurpehlivan.cocktail.presentation.common.theme.PaddingLarge
import com.timurpehlivan.cocktail.presentation.common.theme.SizeLarge
import com.timurpehlivan.cocktail.presentation.common.theme.SpaceLarge
import com.timurpehlivan.cocktail.presentation.common.theme.SpaceSmall
import com.timurpehlivan.cocktail.presentation.feature.detail.CocktailDetailEvent.*
import com.timurpehlivan.cocktail.presentation.feature.detail.CocktailDetailState
import com.timurpehlivan.cocktail.presentation.feature.detail.CocktailDetailViewModel
import com.timurpehlivan.cocktail.util.StringResources
import io.kamel.core.Resource
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url

@Composable
internal fun CocktailDetailContent(
    viewModel: CocktailDetailViewModel,
    state: CocktailDetailState,
    cocktail: Cocktail
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = PaddingLarge)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        if (state.isLoading) CocktailLoadingSpinner()
        state.cocktail?.let {
            DetailSection(it, state.isSaved) {
                viewModel.onEvent(OnButtonClicked(cocktail))
            }
        }
        state.error?.let {
            CocktailError(it) {
                viewModel.onEvent(GetCocktailDetail(cocktail))
            }
        }
    }
}

@Composable
private fun DetailSection(
    cocktail: Cocktail,
    isSaved: Boolean,
    onButtonClicked: (Cocktail) -> Unit
) {
    val painterResource: Resource<Painter> =
        asyncPainterResource(data = Url(cocktail.drinkThumb!!))

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(
                top = CustomSize60,
                bottom = CustomSize60,
                start = PaddingLarge,
                end = PaddingLarge
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            modifier = Modifier
                .clickable { onButtonClicked(cocktail) }
                .size(SizeLarge)
                .align(Alignment.End),
            imageVector =
            if (isSaved)
                Icons.Outlined.Bookmark
            else
                Icons.Outlined.BookmarkBorder,
            contentDescription = StringResources.SAVE_COCKTAIL_BUTTON_DESC,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.size(SizeLarge))
        KamelImage(
            modifier = Modifier
                .size(CustomSize200)
                .aspectRatio(1f / 1.2f)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillHeight,
            resource = painterResource,
            contentDescription = cocktail.name,
            onLoading = { CocktailLoadingSpinner() }
        )
        Spacer(modifier = Modifier.size(SizeLarge))
        Text(
            text = cocktail.name!!,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.size(SpaceLarge))
        CocktailIngredientList(cocktail)
        Spacer(modifier = Modifier.size(SpaceLarge))
        cocktail.instructions?.let { Text(cocktail.instructions!!) }
        Spacer(modifier = Modifier.size(SpaceLarge))
        cocktail.category?.let { Text(cocktail.category!!) }
    }
}

@Composable
private fun CocktailIngredientList(cocktail: Cocktail) {
    val ingredientsWithMeasures = listOf(
        cocktail.ingredient1 to cocktail.measure1,
        cocktail.ingredient2 to cocktail.measure2,
        cocktail.ingredient3 to cocktail.measure3,
        cocktail.ingredient4 to cocktail.measure3,
        cocktail.ingredient5 to cocktail.measure4,
        cocktail.ingredient5 to cocktail.measure5,
        cocktail.ingredient6 to cocktail.measure6,
        cocktail.ingredient7 to cocktail.measure7,
        cocktail.ingredient8 to cocktail.measure8,
        cocktail.ingredient9 to cocktail.measure9,
        cocktail.ingredient10 to cocktail.measure10,
        cocktail.ingredient11 to cocktail.measure11,
        cocktail.ingredient12 to cocktail.measure12,
        cocktail.ingredient13 to cocktail.measure13,
        cocktail.ingredient14 to cocktail.measure14,
        cocktail.ingredient15 to cocktail.measure15,
    )

    Column {
        ingredientsWithMeasures.forEach { (ingredient, measure) ->
            ingredient?.let {
                Text("$ingredient $measure")
                Spacer(modifier = Modifier.size(SpaceSmall))
            }
        }
    }
}