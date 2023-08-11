pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
    versionCatalogs {
        create("appLibs") { from(files("gradle/dependencies/app.toml")) }
        create("commonDataRemoteLibs") { from(files("gradle/dependencies/common/data/remote.toml")) }
        create("commonDataLocalLibs") { from(files("gradle/dependencies/common/data/local.toml")) }
        create("commonPresentationLibs") { from(files("gradle/dependencies/common/presentation.toml")) }
        create("navigationLibs") { from(files("gradle/dependencies/navigation.toml")) }
        create("featureHomeDataLibs") { from(files("gradle/dependencies/feature/home/data.toml")) }
        create("featureHomeDomainLibs") { from(files("gradle/dependencies/feature/home/domain.toml")) }
        create("featureHomePresentationLibs") { from(files("gradle/dependencies/feature/home/presentation.toml")) }
        create("featureFavouriteDataLibs") { from(files("gradle/dependencies/feature/favourite/data.toml")) }
        create("featureFavouriteDomainLibs") { from(files("gradle/dependencies/feature/favourite/domain.toml")) }
        create("featureFavouritePresentationLibs") { from(files("gradle/dependencies/feature/favourite/presentation.toml")) }
        create("featureDetailPresentationLibs") { from(files("gradle/dependencies/feature/detail/presentation.toml")) }
    }
}

rootProject.name = "ComposeSample"
include(":app")
include(":common:domain")
include(":common:presentation")
include(":feature:home:domain")
include(":feature:home:presentation")
include(":feature:detail:presentation")
include(":feature:favourite:domain")
include(":feature:favourite:presentation")
include(":feature:home:data")
include(":feature:favourite:data")
include(":feature:detail:domain")
include(":navigation")
include(":common:data:remote")
include(":common:data:local")
