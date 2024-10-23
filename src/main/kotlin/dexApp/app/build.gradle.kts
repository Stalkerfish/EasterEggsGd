import me.moallemi.gradle.advancedbuildversion.gradleextensions.VersionCodeType

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0" // Adjust version to match your Kotlin version
    id("me.moallemi.advanced-build-version") version "3.0.0"
}

advancedVersioning {
    nameOptions {
        versionMajor(0)
        versionMinor(4)
    }
    codeOptions { versionCodeType(VersionCodeType.GIT_COMMIT_COUNT)}
    outputOptions { }
}

android {
    namespace = "com.alliwonka.dexapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alliwonka.dexapp"
        minSdk = 29
        targetSdk = 34
        versionCode = advancedVersioning.versionCode
        versionName = advancedVersioning.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += listOf(
                "/META-INF/AL2.0",
                "/META-INF/INDEX.LIST",
                "/META-INF/LGPL2.1"
            )
        }
    }
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}