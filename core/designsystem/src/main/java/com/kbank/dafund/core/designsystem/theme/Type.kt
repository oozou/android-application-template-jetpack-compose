package com.kbank.dafund.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kbank.dafund.core.designsystem.R

val LatoFontFamily = FontFamily(
    Font(R.font.lato_regular, FontWeight.Normal),
    Font(R.font.lato_bold, FontWeight.Bold),
    Font(R.font.lato_semibold, FontWeight.SemiBold)
)

val DafundDefaultTextStyle = TextStyle(
    fontFamily = LatoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

val Typography = Typography(
    displayLarge = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp
    ),
    titleSmall = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = DafundDefaultTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    )
)

/**
 * consider using text style name from the MaterialTheme,
 * only use this custom font style when necessary
 **/
val Typography.h1: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )

val Typography.h2: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    )

val Typography.h3: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )

val Typography.h4: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

val Typography.h5: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )

val Typography.body1: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    )

val Typography.body2: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    )

val Typography.small1: TextStyle
    get() = DafundDefaultTextStyle.copy(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    )
