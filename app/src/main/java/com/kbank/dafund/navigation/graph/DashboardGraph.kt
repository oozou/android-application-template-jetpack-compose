package com.kbank.dafund.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.feature.dashboard.DashboardScreen
import com.kbank.dafund.navigation.DASHBOARD_ROUTE

fun NavGraphBuilder.dashboardGraph() {
    composable(DASHBOARD_ROUTE) {
        DashboardScreen()
    }
}
