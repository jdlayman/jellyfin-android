// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        val kotlinVersion: String by project
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:1.7.1.1")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://androidx.dev/snapshots/builds/7404746/artifacts/repository")
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") {
            content {
                includeVersionByRegex(Dependencies.Groups.jellyfin, ".*", ".*-SNAPSHOT")
            }
        }
        maven { setUrl("https://jitpack.io") }
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}
