// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories { mavenCentral() }

    dependencies {
        classpath(kotlin("serialization", version = libs.versions.kotlin.version.get()))
    }
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.org.jlleitschuh.gradle.ktlint)
    alias(libs.plugins.org.jlleitschuh.gradle.ktlint.idea)
    alias(libs.plugins.com.android.library) apply false
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.addKtlintCheckGitPreCommitHook {
    mustRunAfter(tasks.getByPath(":app:build"))
}
