@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(appLibs.plugins.androidLibrary)
    alias(appLibs.plugins.kotlin.android)
}

android {
    namespace = "com.emirhanemmez.navigation"
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
    implementation(project(":feature:home:domain"))
    implementation(project(":feature:favourite:domain"))
    implementation(project(":feature:detail:domain"))
    implementation(project(":feature:home:presentation"))
    implementation(project(":feature:favourite:presentation"))
    implementation(project(":feature:detail:presentation"))
    implementation(navigationLibs.core.ktx)
    implementation(navigationLibs.navigation.compose)
    implementation(navigationLibs.compose.bom)
    implementation(navigationLibs.material3)
    implementation(navigationLibs.ui)
    implementation(navigationLibs.ui.graphics)
    implementation(navigationLibs.ui.tooling.preview)
    implementation(appLibs.appcompat)
    implementation(appLibs.material)
    testImplementation(appLibs.junit)
    androidTestImplementation(appLibs.androidx.test.ext.junit)
    androidTestImplementation(appLibs.espresso.core)
    debugImplementation(navigationLibs.ui.tooling)
}