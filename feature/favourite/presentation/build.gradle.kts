@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
    alias(appLibs.plugins.kotlin.kapt)
    alias(appLibs.plugins.kotlin.parcelize)
    alias(appLibs.plugins.hilt)
}

android {
    namespace = "com.emirhanemmez.feature.favourite.presentation"
    compileSdk = appLibs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = appLibs.versions.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = appLibs.versions.kotlin.compiler.extension.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/LICENSE.md"
            excludes += "/META-INF/LICENSE-notice.md"
            excludes += "/META-INF/*.kotlin_module"
        }
    }
}

dependencies {
    implementation(project(":common:domain"))
    implementation(project(":common:presentation"))
    implementation(project(":feature:favourite:domain"))
    implementation(featureFavouritePresentationLibs.core.ktx)
    implementation(featureFavouritePresentationLibs.lifecycle.runtime.ktx)
    implementation(featureFavouritePresentationLibs.lifecycle.runtime.compose)
    implementation(featureFavouritePresentationLibs.activity.compose)
    implementation(platform(featureFavouritePresentationLibs.compose.bom))
    implementation(featureFavouritePresentationLibs.navigation.compose)
    implementation(featureFavouritePresentationLibs.hilt)
    kapt(featureFavouritePresentationLibs.hilt.compiler)
    implementation(featureFavouritePresentationLibs.hilt.navigation)
    implementation(featureFavouritePresentationLibs.coil)
    implementation(featureFavouritePresentationLibs.localizationManager)
    implementation(featureFavouritePresentationLibs.ui)
    implementation(featureFavouritePresentationLibs.ui.graphics)
    implementation(featureFavouritePresentationLibs.ui.tooling.preview)
    implementation(featureFavouritePresentationLibs.material3)
    androidTestImplementation(featureFavouritePresentationLibs.androidx.test.ext.junit)
    androidTestImplementation(featureFavouritePresentationLibs.espresso.core)
    androidTestImplementation(platform(featureFavouritePresentationLibs.compose.bom))
    androidTestImplementation(featureFavouritePresentationLibs.ui.test.junit4)
    debugImplementation(featureFavouritePresentationLibs.ui.tooling)
    debugImplementation(featureFavouritePresentationLibs.ui.test.manifest)
}