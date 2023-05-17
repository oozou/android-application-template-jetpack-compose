import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.kbank.dafund.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "kbank.dafund.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidHilt") {
            id = "kbank.dafund.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidLibrary") {
            id = "kbank.dafund.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "kbank.dafund.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "kbank.dafund.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}
