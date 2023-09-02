package library

import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.kapt
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("dagger.hilt.android.plugin")
                apply("org.jetbrains.kotlin.kapt")
            }

            dependencies {
                implementation(library("hilt.android"))
                kapt(library("hilt.compiler"))
            }
        }
    }
}