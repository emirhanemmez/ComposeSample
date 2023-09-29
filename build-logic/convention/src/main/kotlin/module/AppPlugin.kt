package module

import com.emirhanemmez.convention.util.androidTestImplementation
import com.emirhanemmez.convention.util.debugImplementation
import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composesample.android.application.compose")
                apply("hilt")
            }

            dependencies {
                implementation(project(":navigation"))
                implementation(project(":core"))
                implementation(project(":common:data:local"))
                implementation(project(":common:data:remote"))
                implementation(project(":common:presentation"))
                implementation(project(":feature:home:data"))
                implementation(project(":feature:home:domain"))
                implementation(project(":feature:home:presentation"))
                implementation(project(":feature:favourite:data"))
                implementation(project(":feature:favourite:domain"))
                implementation(project(":feature:favourite:presentation"))
                implementation(project(":feature:detail:presentation"))
                implementation(library("core.ktx"))
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("activity.compose"))
                implementation(platform(library("compose.bom")))
                implementation(library("ui"))
                implementation(library("ui.graphics"))
                implementation(library("ui.tooling.preview"))
                implementation(library("material3"))
                androidTestImplementation(library("androidx.test.ext.junit"))
                androidTestImplementation(library("espresso.core"))
                androidTestImplementation(platform(library("compose.bom")))
                androidTestImplementation(library("ui.test.junit4"))
                androidTestImplementation(library("navigation.testing"))
                androidTestImplementation(library("hilt.navigation"))
                debugImplementation(library("ui.tooling"))
                debugImplementation(library("ui.test.manifest"))
            }
        }
    }
}
