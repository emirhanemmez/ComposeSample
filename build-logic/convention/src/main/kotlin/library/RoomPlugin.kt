package library

import com.emirhanemmez.convention.util.androidTestImplementation
import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.ksp
import com.emirhanemmez.convention.util.library
import com.emirhanemmez.convention.util.runtimeOnly
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class RoomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                runtimeOnly(library("room.runtime"))
                ksp(library("room.compiler"))
                implementation(library("room.ktx"))
                androidTestImplementation(library("room.testing"))
            }
        }
    }
}