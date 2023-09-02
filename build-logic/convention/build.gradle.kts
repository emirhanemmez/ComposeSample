import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.emirhanemmez.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "composesample.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "composesample.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "composesample.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("hilt") {
            id = "hilt"
            implementationClass = "library.HiltPlugin"
        }
        register("room") {
            id = "room"
            implementationClass = "library.RoomPlugin"
        }
        register("feature") {
            id = "feature"
            implementationClass = "module.FeaturePlugin"
        }
        register("appModule") {
            id = "app"
            implementationClass = "module.AppPlugin"
        }
        register("navigationModule") {
            id = "navigation"
            implementationClass = "module.NavigationPlugin"
        }
        register("coreModule") {
            id = "core"
            implementationClass = "module.CorePlugin"
        }
        register("commonDataLocalModule") {
            id = "common.data.local"
            implementationClass = "module.common.data.LocalDataPlugin"
        }
        register("commonDataRemoteModule") {
            id = "common.data.remote"
            implementationClass = "module.common.data.RemoteDataPlugin"
        }
        register("commonPresentationModule") {
            id = "common.presentation"
            implementationClass = "module.common.PresentationPlugin"
        }
        register("featureDetailPresentationModule") {
            id = "feature.detail.presentation"
            implementationClass = "module.feature.detail.PresentationPlugin"
        }
        register("featureFavouriteDataModule") {
            id = "feature.favourite.data"
            implementationClass = "module.feature.favourite.DataPlugin"
        }
        register("featureFavouriteDomainModule") {
            id = "feature.favourite.domain"
            implementationClass = "module.feature.favourite.DomainPlugin"
        }
        register("featureFavouritePresentationModule") {
            id = "feature.favourite.presentation"
            implementationClass = "module.feature.favourite.PresentationPlugin"
        }
        register("featureHomeDataModule") {
            id = "feature.home.data"
            implementationClass = "module.feature.home.DataPlugin"
        }
        register("featureHomeDomainModule") {
            id = "feature.home.domain"
            implementationClass = "module.feature.home.DomainPlugin"
        }
        register("featureHomePresentationModule") {
            id = "feature.home.presentation"
            implementationClass = "module.feature.home.PresentationPlugin"
        }
    }
}
