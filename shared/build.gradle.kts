plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.android.library)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.compose)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                //Kamel
                implementation(libs.kamel)
                //Coroutines
                implementation(libs.coroutines.core)
                //Moko MVVM
                implementation(libs.moko.mvvm.core)
                //Koin
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                //Voyager
                implementation(libs.voyager.navigator)
                //SQL Delight
                implementation(libs.sqldelight.runtime)
                implementation(libs.sqldelight.coroutines.extensions)
                //Ktor
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.content.negotiation)
                implementation(libs.ktor.serialization)
            }
        }
        val androidMain by getting {
            dependencies {
                //Compose
                api(libs.activity.compose)
                //Koin
                api(libs.koin.android)
                //SQL Delight
                implementation(libs.sqldelight.android.driver)
                //Ktor
                implementation(libs.ktor.android)
            }
        }
        val iosMain by getting {
            dependencies {
                //SQL Delight
                implementation(libs.sqldelight.native.driver)
                //Ktor
                implementation(libs.ktor.darwin)
            }
        }
    }
}

android {
    namespace = (findProperty("android.namespace.shared") as String)
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    kotlin {
        jvmToolchain((findProperty("jvm.version") as String).toInt())
    }
}

sqldelight {
    databases {
        create("CocktailDatabase") {
            packageName.set("com.timurpehlivan.cocktail")
        }
    }
}