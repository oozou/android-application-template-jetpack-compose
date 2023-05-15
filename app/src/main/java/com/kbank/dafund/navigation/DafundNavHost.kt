package com.kbank.dafund.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kbank.dafund.core.ui.main.DafundNavigationDestination
import com.kbank.dafund.feature.dashboard.dashboardGraph
import com.kbank.dafund.feature.search.searchGraph
import com.kbank.dafund.feature.setting.settingGraph

@Composable
fun DafundNavHost(
    navController: NavHostController,
    startDestination: DafundNavigationDestination,
    onNavigateToDestination: DafundNavParam,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        dashboardGraph()
        searchGraph()
        settingGraph()
    }
}

typealias DafundNavParam = (
    destination: DafundNavigationDestination,
    popupTo: DafundNavigationDestination?,
    isInclusive: Boolean,
    routeWithArg: String?
) -> Unit
