import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
}
group = "com.vikas.firebaseloginkmm"
version = "1.0"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
kotlin {
    android()
    iosX64()
    iosArm64()

    cocoapods {
        // Configure fields required by CocoaPods.
        summary = "Kotlin Multiplatform Firebase login sample"
        homepage = "https://github.com/worstkiller/firebaseloginkmm"
        pod("FirebaseAuth")
        pod("FirebaseCore")
        frameworkName = "sharedFramework"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.firebase:firebase-auth:${Versions.firebase_auth_android}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewmodel}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:${Versions.junit}")
            }
        }

        val iosX64Main by getting
        val iosX64Test by getting
        val iosArm64Main by getting

        configure(listOf(iosArm64Main, iosX64Main)) {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.coroutines_native}")
            }
        }
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.withType<org.jetbrains.kotlin.gradle.plugin.mpp.Framework> {
            isStatic = false
        }
    }
}
android {
    compileSdkVersion(AppConfig.compileSdk)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}
/*val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)*/