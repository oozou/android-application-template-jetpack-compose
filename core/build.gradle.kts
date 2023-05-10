@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.plugin.serialization")
    kotlin("kapt")
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.kbank.dafund.core"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(libs.core.ktx)
    implementation(libs.ui.appcompat)
    implementation(libs.datastore)
    implementation(libs.jetbrains.kotlinx.serialization.json)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.stetho)
    implementation(libs.stetho.okhttp3)
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    api(libs.retrofit2)
    api(libs.retrofit2.gson)
    api(libs.retrofit2.log)
    api(libs.jetbrains.kotlinx.coroutine.core)
    api(libs.jetbrains.kotlinx.coroutine.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}
