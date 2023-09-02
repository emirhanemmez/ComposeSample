package module.common.data

import com.emirhanemmez.convention.util.bundle
import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import com.emirhanemmez.convention.util.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RemoteDataPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composesample.android.library")
                apply("org.jetbrains.kotlin.plugin.serialization")
                apply("hilt")
            }

            dependencies {
                implementation(project(":core"))
                implementation(library("core.ktx"))
                implementation(bundle("ktor"))
                implementation(library("kotlin.serialization"))
                implementation(library("mockk"))
                testImplementation(library("coroutines.test"))
                testImplementation(library("junit"))
            }
        }
    }
}