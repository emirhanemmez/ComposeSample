@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
    alias(appLibs.plugins.kotlin.kapt)
    alias(appLibs.plugins.kotlin.parcelize)
    alias(appLibs.plugins.hilt)
}

android {
    namespace = "com.emirhanemmez.feature.detail.presentation"
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
    implementation(project(":common:presentation"))
    implementation(project(":feature:detail:domain"))
    implementation(featureDetailPresentationLibs.core.ktx)
    implementation(featureDetailPresentationLibs.lifecycle.runtime.ktx)
    implementation(featureDetailPresentationLibs.activity.compose)
    implementation(platform(featureDetailPresentationLibs.compose.bom))
    implementation(featureDetailPresentationLibs.navigation.compose)
    implementation(featureDetailPresentationLibs.ui)
    implementation(featureDetailPresentationLibs.ui.graphics)
    implementation(featureDetailPresentationLibs.ui.tooling.preview)
    implementation(featureDetailPresentationLibs.material3)
    implementation(featureDetailPresentationLibs.coil)
    implementation(featureDetailPresentationLibs.hilt)
    kapt(featureDetailPresentationLibs.hilt.compiler)
    androidTestImplementation(featureDetailPresentationLibs.androidx.test.ext.junit)
    androidTestImplementation(featureDetailPresentationLibs.espresso.core)
    androidTestImplementation(platform(featureDetailPresentationLibs.compose.bom))
    androidTestImplementation(featureDetailPresentationLibs.ui.test.junit4)
    debugImplementation(featureDetailPresentationLibs.ui.tooling)
    debugImplementation(featureDetailPresentationLibs.ui.test.manifest)
}