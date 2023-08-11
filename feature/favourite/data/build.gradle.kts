@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
    alias(appLibs.plugins.kotlin.kapt)
    alias(appLibs.plugins.kotlin.serialization)
    alias(appLibs.plugins.ksp)
    alias(appLibs.plugins.hilt)
}

android {
    namespace = "com.emirhanemmez.feature.favourite.data"
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
}

dependencies {
    implementation(project(":common:data:local"))
    implementation(project(":common:domain"))
    implementation(project(":feature:favourite:domain"))
    implementation(featureFavouriteDataLibs.core.ktx)
    implementation(featureFavouriteDataLibs.kotlin.serialization)
    implementation(featureFavouriteDataLibs.hilt)
    kapt(featureFavouriteDataLibs.hilt.compiler)
    runtimeOnly(featureFavouriteDataLibs.room.runtime)
    ksp(featureFavouriteDataLibs.room.compiler)
    implementation(featureFavouriteDataLibs.room.ktx)

    testImplementation(appLibs.junit)
    androidTestImplementation(appLibs.androidx.test.ext.junit)
    androidTestImplementation(appLibs.espresso.core)
}