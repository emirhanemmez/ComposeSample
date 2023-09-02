pluginManagement {
    includeBuild("build-logic")
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
}

rootProject.name = "ComposeSample"
include(":app")
include(":core")
include(":navigation")
include(":common:data:remote")
include(":common:data:local")
include(":common:presentation")
include(":feature:home:data")
include(":feature:home:domain")
include(":feature:home:presentation")
include(":feature:detail:presentation")
include(":feature:favourite:data")
include(":feature:favourite:domain")
include(":feature:favourite:presentation")
