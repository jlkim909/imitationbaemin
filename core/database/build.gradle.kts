plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
    alias(libs.plugins.imitationbaemin.android.hilt)
    alias(libs.plugins.imitationbaemin.android.room)
}

android {
    namespace = "com.hodak.imitationbaemin.core.database"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies{
    api(projects.core.model)
}