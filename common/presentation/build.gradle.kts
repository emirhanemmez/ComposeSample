@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
}

android {
    namespace = "com.emirhanemmez.common.presentation"
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
        }
    }
}

dependencies {
    implementation(commonPresentationLibs.core.ktx)
    implementation(commonPresentationLibs.lifecycle.runtime.ktx)
    implementation(platform(commonPresentationLibs.compose.bom))
    implementation(commonPresentationLibs.ui)
    implementation(commonPresentationLibs.ui.graphics)
    implementation(commonPresentationLibs.ui.tooling.preview)
    implementation(commonPresentationLibs.material3)
    implementation(commonPresentationLibs.navigation.common.ktx)
    implementation(commonPresentationLibs.gson)
    debugImplementation(commonPresentationLibs.ui.tooling)
    debugImplementation(commonPresentationLibs.ui.test.manifest)
    androidTestImplementation(commonPresentationLibs.ui.test.junit4)
    androidTestImplementation(commonPresentationLibs.androidx.test.ext.junit)
    androidTestImplementation(commonPresentationLibs.espresso.core)
}