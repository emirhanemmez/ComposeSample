package module.feature.detail

import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class PresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("feature")
            }

            dependencies {
                implementation(library("localizationManager"))
            }
        }
    }
}