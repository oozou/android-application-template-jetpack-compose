package com.kbank.dafund.ui.main

import com.kbank.dafund.core.designsystem.icon.Icon
import com.kbank.dafund.core.ui.main.DafundNavigationDestination

data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int
) : DafundNavigationDestination
