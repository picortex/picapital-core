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
                api(libs.sentinel.registration.core)
                api(libs.sentinel.enterprise.authentication.core)
                api(libs.flame.schemes.smes)
            }
        }

        val commonTest by getting {
            dependencies {
                api(libs.koncurrent.later.coroutines)
                api(libs.kommander.coroutines)
            }
        }
    }
}