import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

application {
    mainClassName = "MainKt"
}

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.4.3")
    testImplementation("io.kotest:kotest-assertions-core:.4.4.3")
    testImplementation("com.squareup.okhttp3:mockwebserver:5.0.0-alpha.2")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-kotlinx-serialization:2.3.1")
    implementation("com.beust:klaxon:5.5")
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-moshi:2.3.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:1.0-M1-1.4.0-rc")
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")
    implementation("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
}