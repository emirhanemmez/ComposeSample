@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
    alias(appLibs.plugins.kotlin.kapt)
    alias(appLibs.plugins.kotlin.parcelize)
    alias(appLibs.plugins.hilt)
}

android {
    namespace = "com.emirhanemmez.feature.home.presentation"
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
    implementation(project(":feature:home:domain"))
    implementation(featureHomePresentationLibs.core.ktx)
    implementation(featureHomePresentationLibs.lifecycle.runtime.ktx)
    implementation(featureHomePresentationLibs.lifecycle.runtime.compose)
    implementation(featureHomePresentationLibs.activity.compose)
    implementation(platform(featureHomePresentationLibs.compose.bom))
    implementation(featureHomePresentationLibs.navigation.compose)
    implementation(featureHomePresentationLibs.hilt)
    kapt(featureHomePresentationLibs.hilt.compiler)
    implementation(featureHomePresentationLibs.hilt.navigation)
    implementation(featureHomePresentationLibs.localizationManager)
    implementation(featureHomePresentationLibs.coil)
    implementation(featureHomePresentationLibs.ui)
    implementation(featureHomePresentationLibs.ui.graphics)
    implementation(featureHomePresentationLibs.ui.tooling.preview)
    implementation(featureHomePresentationLibs.material3)
    androidTestImplementation(featureHomePresentationLibs.androidx.test.ext.junit)
    androidTestImplementation(featureHomePresentationLibs.espresso.core)
    androidTestImplementation(platform(featureHomePresentationLibs.compose.bom))
    androidTestImplementation(featureHomePresentationLibs.ui.test.junit4)
    debugImplementation(featureHomePresentationLibs.ui.tooling)
    debugImplementation(featureHomePresentationLibs.ui.test.manifest)
}