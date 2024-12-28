plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
    //id("androidx.compose.compiler") version "1.5.1" apply false // Add the required plugin here
}

//buildscript {
//    repositories {
//        google()
//        mavenCentral()
//    }
//    dependencies {
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
//        // Ensure this dependency is included if the plugin is required.
//    }
//}
//
//repositories {
//    google()
//    mavenCentral()
//}
