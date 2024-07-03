plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.compose)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
}

android {
    namespace = "com.hodak.imitationbaemin.core.designsystem"
}

dependencies{
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    implementation(libs.coil.kt.compose)
}