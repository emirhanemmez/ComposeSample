package module

import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class NavigationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composesample.android.library.compose")
                apply("hilt")
            }

            dependencies {
                implementation(project(":common:presentation"))
                implementation(project(":feature:home:presentation"))
                implementation(project(":feature:favourite:presentation"))
                implementation(project(":feature:detail:presentation"))
                implementation(library("core.ktx"))
                implementation(library("navigation.compose"))
                implementation(library("hilt.navigation"))
            }
        }
    }
}