package com.kbank.dafund.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kbank.dafund.R
import com.kbank.dafund.core.designsystem.R as designSystemR

enum class TopLevelNavigation(
    val route: String,
    val isRequireLogin: Boolean,
    @StringRes val title: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int
) {
    DASHBOARD(
        route = DASHBOARD_ROUTE,
        isRequireLogin = false,
        title = R.string.dashboard,
        selectedIcon = designSystemR.drawable.ic_dashboard_black_24dp,
        unselectedIcon = designSystemR.drawable.ic_dashboard_black_24dp
    ),
    SEARCH(
        route = SEARCH_ROUTE,
        isRequireLogin = true,
        title = R.string.search,
        selectedIcon = designSystemR.drawable.ic_search_black_24dp,
        unselectedIcon = designSystemR.drawable.ic_search_black_24dp
    ),
    SETTING(
        route = SETTING_ROUTE,
        isRequireLogin = false,
        title = R.string.setting,
        selectedIcon = designSystemR.drawable.ic_settings_black_24dp,
        unselectedIcon = designSystemR.drawable.ic_settings_black_24dp
    )
}
