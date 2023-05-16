@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("kapt")
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.kbank.dafund.core.ui"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        create("mock") {
            isMinifyEnabled = false
        }

        debug {
            isMinifyEnabled = false
        }

        create("integration") {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    api(project(":core"))

    api(libs.androidx.core.ktx)
    api(libs.androidx.appcompat)
    api(libs.androidx.ui.constraintlayout)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
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

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
