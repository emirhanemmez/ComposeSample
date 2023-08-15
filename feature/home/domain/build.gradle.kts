@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies {
    implementation(project(":common:domain"))
    implementation(libs.javax.inject)
    implementation(libs.coroutines.core)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.junit4)
}