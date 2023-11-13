import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.timurpehlivan.cocktail.presentation.common.theme.PaddingLarge
import com.timurpehlivan.cocktail.util.StringResources

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CocktailTopAppBar(
    title: String,
    navigationIcon: ImageVector? = null,
    onNavigationClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
        },
        navigationIcon = {
            if (navigationIcon != null) {
                Icon(
                    modifier = Modifier
                        .padding(PaddingLarge)
                        .clickable {
                            onNavigationClick?.invoke()
                        },
                    imageVector = navigationIcon,
                    contentDescription = StringResources.BACK_BUTTON_DESC,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}