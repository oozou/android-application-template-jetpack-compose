package com.kbank.dafund.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.kbank.dafund.core.designsystem.icon.Icon.DrawableResourceIcon
import com.kbank.dafund.core.designsystem.icon.Icon.ImageVectorIcon
import com.kbank.dafund.core.designsystem.theme.md_theme_light_secondaryContainer

@Composable
fun DafundBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = md_theme_light_secondaryContainer,
        elevation = 1.dp,
        modifier = Modifier.height(72.dp)
    ) {
        destinations.forEach { destination: TopLevelDestination ->
            val isSelected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            BottomNavigationItem(
                selected = isSelected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon = if (isSelected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    }

                    when (icon) {
                        is ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )

                        is DrawableResourceIcon -> Image(
                            painter = painterResource(id = icon.id),
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                },
                label = {
                    Text(
                        stringResource(destination.iconTextId),
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}
