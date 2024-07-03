plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.compose)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
}

android {
    namespace = "com.hodak.imitationbaemin.core.ui"
}

dependencies{
    api(projects.core.designsystem)
    api(projects.core.model)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}