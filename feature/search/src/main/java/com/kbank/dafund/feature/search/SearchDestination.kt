package com.kbank.dafund.feature.search

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.core.ui.main.DafundNavigationDestination

object SearchDestination : DafundNavigationDestination {
    override val route = "search_route"
    override val destination = "search_destination"
}

fun NavGraphBuilder.searchGraph() {
    composable(route = SearchDestination.route) {
        val viewModel = hiltViewModel<SearchViewModel>()
        SearchScreen(viewModel)
    }
}
