@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.js)
    alias(libs.plugins.kotlin.seriazation)
}

group = "work.racka.materio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation(enforcedPlatform(libs.kotlin.js.wrappers.bom))
    implementation(libs.kotlin.js.emotion)
    implementation(libs.kotlin.js.react)
    implementation(libs.kotlin.js.react.dom)
    implementation(libs.kotlin.js.react.router.dom)
    implementation(libs.kotlin.js.mui)
    implementation(libs.kotlin.js.mui.icons)

    implementation(libs.coroutines.core)
    implementation(libs.kotlinx.serialization.json)

    implementation(npm("date-fns", "2.29.3"))
    implementation(npm("@date-io/date-fns", "2.16.0"))
    implementation(npm("apexcharts-clevision", "3.28.5"))
    implementation(npm("react-apexcharts", "1.4.0"))
    implementation(npm("@popperjs/core", "2.11.6"))
    implementation(npm("nprogress", "0.2.0"))
}

kotlin {
    js(IR) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
            }
        }
    }
}

tasks.create("stage") {
    dependsOn(tasks.getByName("build"))
}

fun kotlinw(target: String): String =
    "org.jetbrains.kotlin-wrappers:kotlin-$target"