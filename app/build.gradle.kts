import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.myorg"
version = "1.0-SNAPSHOT"

val kotestVersion = findProperty("kotest_version")

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    idea
    jacoco
    kotlin("jvm") version "1.5.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.1")

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
    testImplementation("io.mockk:mockk:1.12.4")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
