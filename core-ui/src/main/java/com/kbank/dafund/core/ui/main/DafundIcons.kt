package com.kbank.dafund.core.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.kbank.dafund.core.ui.R

object DafundIcons {
    val MenuSelected get() = R.drawable.ic_home_black_24dp
    val Menu get() = R.drawable.ic_dashboard_black_24dp
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
