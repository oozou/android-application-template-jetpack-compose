import com.android.build.gradle.LibraryExtension
import com.kbank.dafund.configureFlavors
import com.kbank.dafund.configureKotlinAndroid
import com.kbank.dafund.configureKotlinAndroidToolchain
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            configureKotlinAndroidToolchain()
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 33
                configureFlavors(this)
            }
        }
    }
}
