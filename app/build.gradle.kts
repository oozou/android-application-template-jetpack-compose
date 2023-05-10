plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kbank.dafund.mobile"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.kbank.dafund.mobile"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        create("mock") {
            isMinifyEnabled = false
            isDebuggable = true
        }

        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }

        create("integration") {
            isMinifyEnabled = false
            isDebuggable = true
        }

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(libs.core.ktx)
    implementation(libs.ui.appcompat)
    implementation(libs.material3)
    implementation(libs.ui.constraintlayout)
    implementation(libs.ui.livedata.ktx)
    implementation(libs.ui.viewmodel.ktx)
    implementation(libs.ui.fragment.ktx)
    implementation(libs.ui.navigation.ui.ktx)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
