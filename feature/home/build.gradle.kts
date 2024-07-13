plugins {
    alias(libs.plugins.imitationbaemin.android.feature)
    alias(libs.plugins.imitationbaemin.android.library.compose)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
}

android {
    namespace = "com.hodak.imitationbaemin.feature.home"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.domain)

    testImplementation(libs.hilt.android.testing)
    testImplementation(projects.core.testing)

    androidTestImplementation(projects.core.testing)
}