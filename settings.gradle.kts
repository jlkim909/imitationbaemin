pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "imitationbaemin"
// enableFeaturePreview 함수는 이러한 실험적 기능 중 하나를 활성화하는 데 사용
// 이 기능은 Kotlin DSL (build.gradle.kts)에서 하위 프로젝트를 타입 안전하게 참조할 수 있도록 한다.
// 기존의 문자열 기반 접근 대신, 프로젝트를 타입 안전하게 접근할 수 있게 된다
// 예를 들어, 하위 프로젝트를 참조할 때 문자열을 사용하는 대신, project(":subproject")와
// 같은 접근 방식을 사용할 수 있다.
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
