// Top-level build file where you can add configuration options common to all sub-projects/modules.
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

tasks.getByPath(":app:preBuild").dependsOn(tasks.addKtlintCheckGitPreCommitHook)
