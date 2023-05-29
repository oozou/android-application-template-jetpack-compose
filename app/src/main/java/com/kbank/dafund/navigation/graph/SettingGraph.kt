package com.kbank.dafund.navigation.graph

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.feature.authentication.AuthenticationViewModel
import com.kbank.dafund.feature.setting.SettingScreen
import com.kbank.dafund.navigation.LOGIN_ROUTE
import com.kbank.dafund.navigation.REGISTER_FLOW_ROUTE
import com.kbank.dafund.navigation.SETTING_ROUTE

fun NavGraphBuilder.settingGraph(navController: NavController, authenticationViewModel: AuthenticationViewModel) {
    composable(SETTING_ROUTE) {
        SettingScreen(
            isLogin = authenticationViewModel.isLogin.collectAsStateWithLifecycle().value,
            onLogoutButtonClick = {
                authenticationViewModel.logout()
            },
            navigateToLogin = {
                navController.navigate(LOGIN_ROUTE)
            },
            navigateToRegister = {
                navController.navigate(REGISTER_FLOW_ROUTE)
            }
        )
    }
}
