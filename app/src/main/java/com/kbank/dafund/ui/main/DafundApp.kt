package com.kbank.dafund.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kbank.dafund.core.designsystem.theme.DafundTheme
import com.kbank.dafund.feature.dashboard.DashboardDestination
import com.kbank.dafund.navigation.DafundNavHost

@Composable
fun DafundApp(
    appState: DafundAppState = rememberAppState()
) {
    DafundTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Scaffold(
                bottomBar = {
                    if (appState.isShowBottomBar) {
                        DafundBottomBar(
                            destinations = appState.topLevelDestinations,
                            onNavigateToDestination = appState::navigate,
                            currentDestination = appState.currentDestination
                        )
                    }
                }
            ) {
                DafundNavHost(
                    navController = appState.navController,
                    startDestination = DashboardDestination,
                    onNavigateToDestination = appState::navigate,
                    onBackClick = appState::onBackClick,
                    modifier = Modifier.padding(it)
                )
            }
        }
    }
}
