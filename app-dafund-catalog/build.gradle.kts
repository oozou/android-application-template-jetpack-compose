

plugins {
    id("kbank.dafund.android.application")
    id("kbank.dafund.android.hilt")
}

android {
    defaultConfig {
        applicationId = "com.kbank.dafund.catalog"
        versionCode = 1
        versionName = "0.0.1"
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    namespace = "com.kbank.dafund.catalog"

    buildTypes {
        release {
            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    implementation(project(":core:designsystem"))
    implementation(project(":core:ui"))
}
