buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
    }
}
group = "com.vikas.firebaseloginkmm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
