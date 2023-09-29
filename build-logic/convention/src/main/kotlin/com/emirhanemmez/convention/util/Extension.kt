package com.emirhanemmez.convention.util

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.support.delegates.DependencyHandlerDelegate

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun Project.library(libraryName: String) =
    libs.findLibrary(libraryName).get()

fun Project.bundle(bundleName: String) =
    libs.findBundle(bundleName).get()

internal fun Project.version(key: String): String = extensions
    .getByType<VersionCatalogsExtension>()
    .named("libs")
    .findVersion(key)
    .get()
    .requiredVersion

internal fun Project.versionInt(key: String) = version(key).toInt()

internal fun DependencyHandlerDelegate.implementation(dependency: Any) {
    add("implementation", dependency)
}

internal fun DependencyHandlerDelegate.api(dependency: Any) {
    add("api", dependency)
}

internal fun DependencyHandlerDelegate.runtimeOnly(dependency: Any) {
    add("runtimeOnly", dependency)
}

internal fun DependencyHandlerDelegate.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

internal fun DependencyHandlerDelegate.androidTestImplementation(dependency: Any) {
    add("androidTestImplementation", dependency)
}

internal fun DependencyHandlerDelegate.kapt(dependency: Any) {
    add("kapt", dependency)
}

internal fun DependencyHandlerDelegate.kaptAndroidTest(dependency: Any) {
    add("kaptAndroidTest", dependency)
}

internal fun DependencyHandlerDelegate.ksp(dependency: Any) {
    add("ksp", dependency)
}

internal fun DependencyHandlerDelegate.kspAndroidTest(dependency: Any) {
    add("kspAndroidTest", dependency)
}

internal fun DependencyHandlerDelegate.debugImplementation(dependency: Any) {
    add("debugImplementation", dependency)
}