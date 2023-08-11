plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
    alias(appLibs.plugins.kotlin.kapt)
    alias(appLibs.plugins.kotlin.serialization)
    alias(appLibs.plugins.hilt)
    alias(appLibs.plugins.ksp)
}

android {
    namespace = "com.emirhanemmez.common.data.local"
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
    implementation(commonDataLocalLibs.core.ktx)
    implementation(commonDataLocalLibs.kotlin.serialization)
    implementation(commonDataLocalLibs.hilt)
    kapt(commonDataLocalLibs.hilt.compiler)
    runtimeOnly(commonDataLocalLibs.room.runtime)
    ksp(commonDataLocalLibs.room.compiler)
    implementation(commonDataLocalLibs.room.ktx)
    androidTestImplementation(commonDataLocalLibs.room.testing)
    androidTestImplementation(commonDataLocalLibs.androidx.test.ext.junit)
    androidTestImplementation(commonDataLocalLibs.coroutines.test)
    androidTestImplementation(commonDataLocalLibs.test.runner)
}