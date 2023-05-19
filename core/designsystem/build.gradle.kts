plugins {
    id("kbank.dafund.android.library.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.kbank.dafund.core.designsystem"

    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {
    api(libs.androidx.core.ktx)

    val composeBom = platform(libs.androidx.compose.bom)
    api(composeBom)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material.iconsExtended)

    api(libs.coil.compose)

    // Android Studio Preview support
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.tooling)
}
