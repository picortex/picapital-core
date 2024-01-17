plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

kotlin {
    jvm { library() }
    js(IR) { library() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.sentinel.schemes.registration.email)
                api(libs.sentinel.schemes.enterprise.authentication.email)
                api(libs.flame.schemes.smes)
                api(libs.sanity.core)
            }
        }
    }
}