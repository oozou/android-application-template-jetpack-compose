plugins {
    id("kbank.dafund.android.library.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.kbank.dafund.core.ui"

    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    api(libs.hilt.navigation.compose)

    val composeBom = platform(libs.androidx.compose.bom)
    api(composeBom)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material)

    // Android Studio Preview support
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.ui.tooling)

    api(libs.androidx.compose.activity)
    api(libs.androidx.lifecycle.viewmodel.compose)
    api(libs.androidx.lifecycle.runtime.compose)
    api(libs.androidx.compose.animation)
    api(libs.androidx.navigation.compose)
    api(libs.coil.compose)
    api(libs.androidx.constraintlayout.compose)
}
