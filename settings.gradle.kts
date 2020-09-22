pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        jcenter()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android" || requested.id.name == "kotlin-android-extensions") {
                useModule("com.android.tools.build:gradle:${Versions.gradle}")
            }
        }
    }
}
rootProject.name = "FirebaseLoginKMM"


include(":androidApp")
include(":sharedFramework")

