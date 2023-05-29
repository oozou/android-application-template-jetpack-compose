package com.kbank.dafund.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kbank.dafund.feature.authentication.AuthenticationViewModel
import com.kbank.dafund.navigation.graph.dashboardGraph
import com.kbank.dafund.navigation.graph.loginGraph
import com.kbank.dafund.navigation.graph.registerGraph
import com.kbank.dafund.navigation.graph.searchGraph
import com.kbank.dafund.navigation.graph.settingGraph

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    authenticationViewModel: AuthenticationViewModel
) {
    NavHost(navController, startDestination, modifier) {
        dashboardGraph()
        searchGraph(authenticationViewModel)
        settingGraph(navController, authenticationViewModel)
        loginGraph(navController, authenticationViewModel)
        registerGraph(navController)
    }
}
