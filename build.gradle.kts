// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidApplication) apply false
    alias(appLibs.plugins.kotlin.android) apply false
    alias(appLibs.plugins.androidLibrary) apply false
    alias(appLibs.plugins.kotlin.jvm) apply false
    alias(appLibs.plugins.kotlin.kapt) apply false
    alias(appLibs.plugins.kotlin.serialization) apply false
    alias(appLibs.plugins.kotlin.parcelize) apply false
    alias(appLibs.plugins.ksp) apply false
    alias(appLibs.plugins.hilt) apply false
}
true // Needed to make the Suppress annotation work for the plugins block