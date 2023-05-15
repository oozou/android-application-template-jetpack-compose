package com.kbank.dafund.feature.setting

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.core.ui.main.DafundNavigationDestination

object SettingDestination : DafundNavigationDestination {
    override val route = "setting_route"
    override val destination = "setting_destination"
}

fun NavGraphBuilder.settingGraph() {
    composable(route = SettingDestination.route) {
        val viewModel = hiltViewModel<SettingViewModel>()
        SettingScreen(viewModel)
    }
}
