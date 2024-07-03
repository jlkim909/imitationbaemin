import com.hodak.imitationbaemin.HoBuildType

plugins {
    alias(libs.plugins.imitationbaemin.android.application)
    alias(libs.plugins.imitationbaemin.android.application.compose)
    alias(libs.plugins.imitationbaemin.android.application.flavors)
    alias(libs.plugins.imitationbaemin.android.application.jacoco)
    alias(libs.plugins.imitationbaemin.android.hilt)
}

android {
    namespace = "com.hodak.imitationbaemin"

    defaultConfig {
        applicationId = "com.hodak.imitationbaemin"
        versionCode = 1
        versionName = "0.1.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        testInstrumentationRunner = "com.hodak.imitationbaemin.core.testing.HoTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = HoBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = true
            applicationIdSuffix = HoBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.named("debug").get()
            // Ensure Baseline Profile is fresh for release builds.
            //baselineProfile.automaticGenerationDuringBuild = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
}