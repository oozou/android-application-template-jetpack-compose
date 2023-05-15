pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Dafund-android"
include(":app")
include(":core")
include(":core-ui")
include(":feature-dashboard")
include(":feature-search")
include(":feature-setting")
