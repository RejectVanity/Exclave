import com.google.protobuf.gradle.*

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.protobuf")
}

setupKotlinCommon()

dependencies {
    protobuf(project(":library:proto"))

    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    api("com.google.protobuf:protobuf-java:4.27.2")
}
android {
    namespace = "com.v2ray.core"
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.26.1"
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                create("java")
            }
        }
    }
}
