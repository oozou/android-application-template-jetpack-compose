package com.kbank.dafund.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kbank.dafund.R
import com.kbank.dafund.core.ui.main.DafundIcons
import com.kbank.dafund.core.ui.main.DafundNavigationDestination
import com.kbank.dafund.core.ui.main.Icon

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
): DafundAppState {
    return remember(navController) {
        DafundAppState(navController)
    }
}

@Stable
class DafundAppState(
    val navController: NavHostController
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val isShowBottomBar: Boolean
        @Composable get() = true // TODO: add logic once we have requirements

    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            route = com.kbank.dafund.feature.dashboard.DashboardDestination.route,
            destination = com.kbank.dafund.feature.dashboard.DashboardDestination.destination,
            selectedIcon = Icon.DrawableResourceIcon(DafundIcons.MenuSelected),
            unselectedIcon = Icon.DrawableResourceIcon(DafundIcons.Menu),
            iconTextId = R.string.dashboard
        ),
        TopLevelDestination(
            route = com.kbank.dafund.feature.search.SearchDestination.route,
            destination = com.kbank.dafund.feature.search.SearchDestination.destination,
            selectedIcon = Icon.DrawableResourceIcon(android.R.drawable.ic_menu_search),
            unselectedIcon = Icon.DrawableResourceIcon(android.R.drawable.ic_menu_search),
            iconTextId = R.string.search
        ),
        TopLevelDestination(
            route = com.kbank.dafund.feature.setting.SettingDestination.route,
            destination = com.kbank.dafund.feature.setting.SettingDestination.destination,
            selectedIcon = Icon.DrawableResourceIcon(DafundIcons.MenuSelected),
            unselectedIcon = Icon.DrawableResourceIcon(DafundIcons.Menu),
            iconTextId = R.string.setting
        )
    )

    fun navigate(
        destination: DafundNavigationDestination,
        popupToDestination: DafundNavigationDestination? = null,
        isInclusive: Boolean = false,
        routeWithArg: String? = null
    ) {
        if (destination is TopLevelDestination) {
            navController.navigate(routeWithArg ?: destination.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                // Restore state when re-selecting a previously selected item
                restoreState = true
            }
        } else {
            navController.navigate(routeWithArg ?: destination.route) {
                popupToDestination?.let {
                    popUpTo(popupToDestination.route) {
                        inclusive = isInclusive
                    }
                }
            }
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}
