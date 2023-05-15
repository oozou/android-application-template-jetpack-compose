import com.google.firebase.appdistribution.gradle.firebaseAppDistribution

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("com.google.firebase.appdistribution")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kbank.dafund"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.kbank.dafund"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        System.getenv("ANDROID_KEYSTORE_PASSWORD")?.let {
            create("release") {
                storeFile = file("release.keystore")
                storePassword = System.getenv("ANDROID_KEYSTORE_PASSWORD")
                keyAlias = System.getenv("ANDROID_KEYSTORE_ALIAS")
                keyPassword = System.getenv("ANDROID_KEYSTORE_KEY_PASSWORD")
            }
        }
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
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = if (System.getenv("ANDROID_KEYSTORE_PASSWORD") != null) {
                signingConfigs.getByName("release")
            } else {
                signingConfigs.getByName("debug")
            }
            firebaseAppDistribution {
                artifactType = "APK"
                groups = "internal-testers"
                serviceCredentialsFile = "service_credential.json"
                releaseNotesFile = "release_notes.txt"
                artifactPath = System.getenv("APK_PATH")?.lowercase()
            }
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

    val envDimension = "env"
    flavorDimensions += envDimension
    productFlavors {
        create("develop") {
            dimension = envDimension
            applicationIdSuffix = ".dev"
        }
        create("production") {
            dimension = envDimension
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-ui"))
    implementation(project(":feature-dashboard"))
    implementation(project(":feature-search"))
    implementation(project(":feature-setting"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    // UI Tests
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
