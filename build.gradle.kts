plugins {
    val kotlin = "1.4-M1"
    kotlin("jvm") version kotlin
    kotlin("plugin.spring") version kotlin
    id("online.colaba.docker") version "1.1.1"
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.github.ben-manes.versions") version "0.28.0"
}

repositories { mavenCentral(); mavenLocal(); maven("https://dl.bintray.com/kotlin/kotlin-eap") }

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    annotationProcessor("org.springframework.boot", "spring-boot-configuration-processor")

    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")
    implementation("org.postgresql", "postgresql")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")

    implementation("org.springframework.boot", "spring-boot-starter-web")

    implementation("org.springframework.boot", "spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-oauth2-client")
    implementation("org.springframework.security:spring-security-oauth2-jose")

    testImplementation("org.springframework.boot", "spring-boot-starter-test")
}

tasks {
    val java = "11"
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions { jvmTarget = java }; sourceCompatibility = java; targetCompatibility = java
    }
    test { useJUnitPlatform() }
}
