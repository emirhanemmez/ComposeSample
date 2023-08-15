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
        create("libs") { from(files("gradle/dependencies/app.toml")) }
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
