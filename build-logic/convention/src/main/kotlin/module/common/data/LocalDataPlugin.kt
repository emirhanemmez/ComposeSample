package module.common.data

import com.emirhanemmez.convention.util.androidTestImplementation
import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LocalDataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composesample.android.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("room")
                apply("hilt")
            }

            dependencies {
                implementation(project(":core"))
                implementation(library("core.ktx"))
                implementation(library("kotlin.serialization"))
                androidTestImplementation(library("coroutines.test"))
                androidTestImplementation(library("androidx.test.ext.junit"))
            }
        }
    }
}