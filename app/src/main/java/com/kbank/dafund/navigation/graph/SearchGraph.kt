package com.kbank.dafund.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.feature.authentication.AuthenticationViewModel
import com.kbank.dafund.feature.authentication.login.RequireAuthentication
import com.kbank.dafund.feature.search.SearchScreen
import com.kbank.dafund.navigation.SEARCH_ROUTE

fun NavGraphBuilder.searchGraph(authenticationViewModel: AuthenticationViewModel) {
    composable(SEARCH_ROUTE) {
        RequireAuthentication(authenticationViewModel) {
            SearchScreen()
        }
    }
}
