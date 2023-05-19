pluginManagement {
    includeBuild("build-logic")
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
include(":core:common")
include(":core:designsystem")
include(":core:ui")
include(":feature:dashboard")
include(":feature:search")
include(":feature:setting")
include(":app-dafund-catalog")
