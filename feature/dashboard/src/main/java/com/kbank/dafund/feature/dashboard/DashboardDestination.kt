package com.kbank.dafund.feature.dashboard

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.core.ui.main.DafundNavigationDestination

object DashboardDestination : DafundNavigationDestination {
    override val route = "dashboard_route"
    override val destination = "dashboard_destination"
}

fun NavGraphBuilder.dashboardGraph() {
    composable(route = DashboardDestination.route) {
        val viewModel = hiltViewModel<DashboardViewModel>()
        DashboardScreen(viewModel)
    }
}
