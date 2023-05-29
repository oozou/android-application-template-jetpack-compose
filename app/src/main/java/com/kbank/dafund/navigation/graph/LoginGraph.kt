package com.kbank.dafund.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kbank.dafund.feature.authentication.AuthenticationViewModel
import com.kbank.dafund.feature.authentication.login.LoginScreen
import com.kbank.dafund.navigation.LOGIN_ROUTE

fun NavGraphBuilder.loginGraph(navController: NavController, authenticationViewModel: AuthenticationViewModel) {
    composable(LOGIN_ROUTE) {
        LoginScreen(
            authenticationViewModel = authenticationViewModel,
            onLoginSuccess = {
                navController.popBackStack()
            }
        )
    }
}
