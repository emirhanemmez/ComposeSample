@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("java-library")
    alias(appLibs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(project(":common:domain"))
    implementation(featureFavouriteDomainLibs.javax.inject)
    implementation(featureFavouriteDomainLibs.coroutines.core)
    testImplementation(featureFavouriteDomainLibs.junit4)
    testImplementation(featureFavouriteDomainLibs.coroutines.test)
}