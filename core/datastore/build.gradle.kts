plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
    alias(libs.plugins.imitationbaemin.android.hilt)
}

android {
    defaultConfig {
        consumerProguardFiles("consumer-proguard-rules.pro")
    }
    namespace = "com.hodak.imitationbaemin.core.datastore"
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
    }
}

dependencies{
    api(libs.androidx.dataStore.core)
    api(projects.core.datastoreProto)
    api(projects.core.model)

    implementation(projects.core.common)
}