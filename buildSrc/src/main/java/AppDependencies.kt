import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    val appcompat = "androidx.appcompat:appcompat:1.6.1"
    val coreKtx = "androidx.core:core-ktx:1.9.0"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:2.1.4"
    val material = "com.google.android.material:material:1.8.0"
    val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
    val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.5.3"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.5.3"

    //test libs
    val junit = "junit:junit:4.12"
    val extJUnit = "androidx.test.ext:junit:1.1.5"
    val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

//https://medium.com/android-dev-hacks/kotlin-dsl-gradle-scripts-in-android-made-easy-b8e2991e2ba
