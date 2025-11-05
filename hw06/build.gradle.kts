
group = "com.otus.java.advanced"
version = "1.0.0-SNAPSHOT"


plugins {
    `java-library`
    id("nebula.release") version "19.0.10"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}
repositories{
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.projectlombok:lombok")
    implementation("org.mapstruct:mapstruct:1.6.0")
    annotationProcessor("org.projectlombok:lombok")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.6.0")
    api("com.h2database:h2:2.4.240")
}