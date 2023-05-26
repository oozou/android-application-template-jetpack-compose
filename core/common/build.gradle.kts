plugins {
    id("kbank.dafund.android.library")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kbank.dafund.android.hilt")
    id("com.klaxit.hiddensecrets")
    id("org.jetbrains.kotlin.kapt")
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
    implementation(libs.androidx.security)

    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)
    api(libs.androidx.room.ktx)

    implementation(libs.android.security.sqlcipher)
    implementation(libs.androidx.security.ktx)

    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    api(libs.retrofit2)
    api(libs.retrofit2.kotlin.serialization.converter)
    api(libs.retrofit2.log)
    api(libs.jetbrains.kotlinx.coroutine.core)
    api(libs.jetbrains.kotlinx.coroutine.android)
    api(libs.androidx.compose.runtime.livedata.ktx)
    api(libs.androidx.lifecycle.viewmodel.compose)
    api(libs.androidx.lifecycle.viewmodel)

    testImplementation(libs.junit)
}
