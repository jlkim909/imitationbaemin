plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
    alias(libs.plugins.imitationbaemin.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.hodak.imitationbaemin.core.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies{
    api(projects.core.database)
    api(projects.core.datastore)
}