plugins{
    alias(libs.plugins.imitationbaemin.android.library)
    alias(libs.plugins.imitationbaemin.android.library.jacoco)
    id("com.google.devtools.ksp")
}

android{
    namespace = "com.hodak.imitationbaemin.core.domain"
}