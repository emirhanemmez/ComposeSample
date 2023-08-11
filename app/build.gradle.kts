@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidApplication)
    alias(appLibs.plugins.kotlin.android)
    alias(appLibs.plugins.kotlin.kapt)
    alias(appLibs.plugins.hilt)
}

android {
    namespace = "com.emirhanemmez.composesample"
    compileSdk = appLibs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.emirhanemmez.composesample"
        minSdk = appLibs.versions.minSdk.get().toInt()
        targetSdk = appLibs.versions.targetSdk.get().toInt()
        versionCode = appLibs.versions.versionCode.get().toInt()
        versionName = appLibs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    implementation(project(":common:data:local"))
    implementation(project(":common:data:remote"))
    implementation(project(":common:domain"))
    implementation(project(":common:presentation"))
    implementation(project(":navigation"))
    implementation(project(":feature:home:data"))
    implementation(project(":feature:home:domain"))
    implementation(project(":feature:home:presentation"))
    implementation(project(":feature:detail:domain"))
    implementation(project(":feature:detail:presentation"))
    implementation(project(":feature:favourite:data"))
    implementation(project(":feature:favourite:domain"))
    implementation(project(":feature:favourite:presentation"))
    implementation(appLibs.core.ktx)
    implementation(appLibs.lifecycle.runtime.ktx)
    implementation(appLibs.hilt)
    kapt(appLibs.hilt.compiler)
    implementation(appLibs.activity.compose)
    implementation(platform(appLibs.compose.bom))
    implementation(appLibs.ui)
    implementation(appLibs.ui.graphics)
    implementation(appLibs.ui.tooling.preview)
    implementation(appLibs.material3)
    testImplementation(appLibs.junit)
    androidTestImplementation(appLibs.androidx.test.ext.junit)
    androidTestImplementation(appLibs.espresso.core)
    androidTestImplementation(platform(appLibs.compose.bom))
    androidTestImplementation(appLibs.ui.test.junit4)
    debugImplementation(appLibs.ui.tooling)
    debugImplementation(appLibs.ui.test.manifest)
}