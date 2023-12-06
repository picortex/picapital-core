pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

//dependencyResolutionManagement {
//    versionCatalogs {
//        file("versions").listFiles().map {
//            it.nameWithoutExtension to it.absolutePath
//        }.forEach { (name, path) ->
//            create(name) { from(files(path)) }
//        }
//    }
//}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "cinematic", "keep", "lexi", "captain", "neat", "kash-api", "geo-api",
    "kronecker", "symphony", "epsilon-api", "krono-core", "hormone",
    "identifier-api", "identifier-client", "kommerce", "bee", "kost", "cabinet-api",
    "krest", "snitch", "bringer", "koder", "sentinel-core",
    "koncurrent", "kommander", "raven-core", "kiota", "flame-core",
).forEach { includeBuild("../$it") }

rootProject.name = "picapital-core"

includeSubs("picapital", ".", "schemes")
