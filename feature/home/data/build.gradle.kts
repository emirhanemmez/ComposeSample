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
    namespace = "com.emirhanemmez.feature.home.data"
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
    implementation(project(":common:data:remote"))
    implementation(project(":common:data:local"))
    implementation(project(":common:domain"))
    implementation(project(":feature:home:domain"))
    implementation(featureHomeDataLibs.core.ktx)
    implementation(featureHomeDataLibs.ktor.core)
    implementation(featureHomeDataLibs.hilt)
    kapt(featureHomeDataLibs.hilt.compiler)
    runtimeOnly(featureHomeDataLibs.room.runtime)
    implementation(featureHomeDataLibs.room.ktx)
    ksp(featureHomeDataLibs.room.compiler)
    implementation(featureHomeDataLibs.kotlin.serialization)
    testImplementation(appLibs.junit)
    testImplementation(featureHomeDataLibs.coroutines.test)
    testImplementation(featureHomeDataLibs.mockk)
    androidTestImplementation(appLibs.androidx.test.ext.junit)
    androidTestImplementation(appLibs.espresso.core)
}