plugins {
	java
	id("org.springframework.boot") version "3.0.7"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.bike"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2022.0.3"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("io.micrometer:micrometer-tracing-bridge-brave")
	implementation("io.zipkin.reporter2:zipkin-reporter-brave")
	implementation("io.micrometer:micrometer-registry-prometheus")
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")

	compileOnly ("org.projectlombok:lombok:1.18.28")
	annotationProcessor ("org.projectlombok:lombok:1.18.28")

	testCompileOnly ("org.projectlombok:lombok:1.18.28")
	testAnnotationProcessor ("org.projectlombok:lombok:1.18.28")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
