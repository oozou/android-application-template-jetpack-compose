plugins {
    id("kbank.dafund.android.library")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kbank.dafund.android.hilt")
    id("com.klaxit.hiddensecrets")
}

android {
    namespace = "com.kbank.dafund.core"

    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.datastore)
    implementation(libs.jetbrains.kotlinx.serialization.json)
    implementation(libs.stetho)
    implementation(libs.stetho.okhttp3)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    api(libs.retrofit2)
    api(libs.retrofit2.kotlin.serialization.converter)
    api(libs.retrofit2.log)
    api(libs.jetbrains.kotlinx.coroutine.core)
    api(libs.jetbrains.kotlinx.coroutine.android)

    testImplementation(libs.junit)
}
