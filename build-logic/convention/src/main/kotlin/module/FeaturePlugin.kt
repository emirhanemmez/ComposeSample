package module

import com.emirhanemmez.convention.util.androidTestImplementation
import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composesample.android.library.compose")
                apply("org.jetbrains.kotlin.plugin.parcelize")
                apply("hilt")
            }

            dependencies {
                implementation(project(":core"))
                implementation(project(":common:presentation"))
                implementation(library("activity.compose"))
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("lifecycle.runtime.compose"))
                implementation(library("navigation.compose"))
                implementation(library("hilt.navigation"))
                implementation(library("coil"))
                androidTestImplementation(library("androidx.test.ext.junit"))
                androidTestImplementation(library("espresso.core"))
            }
        }
    }
}