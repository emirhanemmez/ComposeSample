package module.common

import com.emirhanemmez.convention.util.androidTestImplementation
import com.emirhanemmez.convention.util.implementation
import com.emirhanemmez.convention.util.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class PresentationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composesample.android.library.compose")
            }

            dependencies {
                implementation(library("lifecycle.runtime.ktx"))
                implementation(library("navigation.common.ktx"))
                implementation(library("gson"))
                androidTestImplementation(library("androidx.test.ext.junit"))
                androidTestImplementation(library("espresso.core"))
                androidTestImplementation(platform(library("compose.bom")))
                androidTestImplementation(library("ui.test.junit4"))
            }
        }
    }
}