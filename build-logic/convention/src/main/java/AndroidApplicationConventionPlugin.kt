import com.android.build.api.dsl.ApplicationExtension
import com.kbank.dafund.configureAndroidCompose
import com.kbank.dafund.configureFlavors
import com.kbank.dafund.configureKotlinAndroid
import com.kbank.dafund.configureKotlinAndroidToolchain
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            configureKotlinAndroidToolchain()
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig.targetSdk = 33
                configureFlavors(this)
            }
        }
    }

}
