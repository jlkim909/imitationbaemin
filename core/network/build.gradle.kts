plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
    alias(libs.plugins.imitationbaemin.android.hilt)
}

android {
    buildFeatures {
        buildConfig = true
    }
    namespace = "com.hodak.imitationbaemin.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}