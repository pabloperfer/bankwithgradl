plugins {
    java
    `java-library`
    application
    checkstyle
    id("com.github.spotbugs") version "4.7.1"

}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("Main")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.4.0")
    implementation("org.json:json:20211205")
    spotbugs("com.github.spotbugs:spotbugs:4.5.3")

}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("--enable-preview")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.getByName<Test>("test") {
    source = fileTree("/src/main/java")
    doFirst {
        println(" executing the unit tests... ")
    }
    useTestNG() {
        useDefaultListeners = true
        testLogging.showStandardStreams = true
}
    jvmArgs("--enable-preview")
    mustRunAfter("checkstyle")
}

checkstyle {
    toolVersion = "9.3"
    config = rootProject.resources.text.fromFile("etc/checkstyle/google_checks.xml")
}

tasks.register<Checkstyle>("checkstyle") {
    println("Checking coding style warnings and errors before unit tests.......")
    classpath = files()
    dependsOn ("spotbugs")
}

spotbugs {
    showProgress.set(true)
    tasks.spotbugsMain {
        dependsOn("test")
        ignoreFailures = true
        reports.create("html") {
            isEnabled = true
        }
    }
    tasks.spotbugsTest {
        reports.create("html") {
            isEnabled = false
        }
          isEnabled=false
    }
}













