plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kbank.dafund.mobile"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.kbank.dafund.mobile"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(AppDependencies.coreKtx)
    implementation(AppDependencies.appcompat)
    implementation(AppDependencies.material)
    implementation(AppDependencies.constraintLayout)
    implementation(AppDependencies.liveDataKtx)
    implementation(AppDependencies.viewModelKtx)
    implementation(AppDependencies.fragmentKtx)
    implementation(AppDependencies.navigationUiKtx)

    testImplementation(AppDependencies.testLibraries)
    testImplementation(AppDependencies.androidTestLibraries)
}
