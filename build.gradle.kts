// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0-beta01" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("org.jlleitschuh.gradle.ktlint") version "11.3.2"
    id("org.jlleitschuh.gradle.ktlint-idea") version "11.3.2"
}

allprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}

tasks.getByPath(":app:preBuild").dependsOn(tasks.addKtlintCheckGitPreCommitHook)
