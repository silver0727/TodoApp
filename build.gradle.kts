// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.gradle apply false
    id ("com.android.library") version Versions.gradle apply false
    kotlin("android") version Versions.kotlin apply false
}

buildscript {
    dependencies {
        classpath(BuildPlugins.dagger_hilt_plugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}