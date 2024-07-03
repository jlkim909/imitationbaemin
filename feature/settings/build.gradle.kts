plugins {
    alias(libs.plugins.imitationbaemin.android.feature)
    alias(libs.plugins.imitationbaemin.android.library.compose)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
}

android {
    namespace = "com.hodak.imitationbaemin.feature.settings"
}