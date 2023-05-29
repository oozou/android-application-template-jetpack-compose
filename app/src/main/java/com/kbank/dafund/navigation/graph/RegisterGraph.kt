package com.kbank.dafund.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kbank.dafund.feature.authentication.register.RegisterScreen
import com.kbank.dafund.feature.authentication.register.RegisterSuccessScreen
import com.kbank.dafund.navigation.REGISTER_FLOW_ROUTE
import com.kbank.dafund.navigation.REGISTER_ROUTE
import com.kbank.dafund.navigation.REGISTER_SUCCESS_ROUTE

fun NavGraphBuilder.registerGraph(navController: NavHostController) {
    navigation(startDestination = REGISTER_ROUTE, route = REGISTER_FLOW_ROUTE) {
        composable(REGISTER_ROUTE) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(REGISTER_SUCCESS_ROUTE) {
                        popUpTo(REGISTER_ROUTE) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(REGISTER_SUCCESS_ROUTE) {
            RegisterSuccessScreen(
                onClose = {
                    navController.popBackStack()
                }
            )
        }
    }
}
