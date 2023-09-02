package module.feature.favourite

import com.emirhanemmez.convention.util.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("common.data.local")
            }

            dependencies {
                implementation(project(":common:data:local"))
                implementation(project(":feature:favourite:domain"))
            }
        }
    }
}