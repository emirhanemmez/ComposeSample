package com.emirhanemmez.convention

import com.android.build.api.dsl.CommonExtension
import com.emirhanemmez.convention.util.libs
import org.gradle.api.Project

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("kotlin-compiler-extension").get().toString()
        }
    }

    configureKotlinAndroid(commonExtension)
}
