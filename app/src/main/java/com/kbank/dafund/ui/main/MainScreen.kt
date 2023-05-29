package com.kbank.dafund.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kbank.dafund.feature.authentication.AuthenticationViewModel
import com.kbank.dafund.navigation.AppNavHost
import com.kbank.dafund.navigation.DASHBOARD_ROUTE
import com.kbank.dafund.navigation.TopLevelNavigation

@Composable
fun MainScreen() {
    val authenticationViewModel = hiltViewModel<AuthenticationViewModel>()
    val isLogin by authenticationViewModel.isLogin.collectAsStateWithLifecycle()
    val navController = rememberNavController()
    val topLevelNavigation by remember {
        mutableStateOf(TopLevelNavigation.values())
    }
    val topLevelNavigationRoute by remember {
        val map = mutableMapOf<String, TopLevelNavigation>()
        topLevelNavigation.forEach {
            map[it.route] = it
        }
        mutableStateOf(map)
    }
    var isShowBottomBar by remember {
        mutableStateOf(true)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val currentTopLevelNavigation = topLevelNavigationRoute[currentRoute]
    val isTopLevel = currentTopLevelNavigation != null
    isShowBottomBar = isTopLevel && !(currentTopLevelNavigation?.isRequireLogin == true && !isLogin)
    Scaffold(bottomBar = {
        AnimatedVisibility(
            visible = isShowBottomBar,
            enter = slideInHorizontally() + fadeIn(),
            exit = slideOutHorizontally() + fadeOut()
        ) {
            BottomNavigation(backgroundColor = MaterialTheme.colorScheme.primaryContainer) {
                topLevelNavigation.forEach { item ->
                    val isSelected = currentRoute == item.route
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(
                                    id = if (isSelected) {
                                        item.selectedIcon
                                    } else {
                                        item.unselectedIcon
                                    }
                                ),
                                contentDescription = stringResource(item.title)
                            )
                        },
                        label = { Text(stringResource(item.title), style = MaterialTheme.typography.bodySmall) },
                        selected = isSelected,
                        onClick = {
                            if (!isSelected) {
                                navController.navigate(item.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        }
                    )
                }
            }
        }
    }) { innerPadding ->
        AppNavHost(
            navController,
            startDestination = DASHBOARD_ROUTE,
            modifier = Modifier.padding(innerPadding),
            authenticationViewModel
        )
    }
}
