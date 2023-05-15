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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.kbank.dafund.core.ui.main.Icon
import com.kbank.dafund.core.ui.theme.Green80
import com.kbank.dafund.core.ui.theme.GreenGray80

@Composable
fun DafundBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = Green80,
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
                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )

                        is Icon.DrawableResourceIcon -> Image(
                            painter = painterResource(id = icon.id),
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp),
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                },
                label = {
                    Text(
                        stringResource(destination.iconTextId),
                        color = if (isSelected) GreenGray80 else Color.White,
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
