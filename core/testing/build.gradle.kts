plugins {
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.compose)
    alias(libs.plugins.imitationbaemin.android.hilt)
}

android {
    namespace = "com.hodak.imitationbaemin.core.testing"
}

dependencies{
    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
}