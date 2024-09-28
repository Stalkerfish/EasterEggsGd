import org.gradle.internal.os.OperatingSystem
import java.net.URL
import java.util.zip.ZipInputStream

plugins {
    kotlin("jvm") version "1.9.23"
    id("com.utopia-rise.godot-kotlin-jvm") version "0.9.0-4.2.2"
    id("org.jetbrains.compose") version "1.6.11"

}

repositories {
    mavenLocal()
    mavenCentral()
    google()
    maven("https://repo.gradle.org/gradle/libs-releases/")

}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.skiko:skiko-awt-runtime-linux-x64:0.8.12")
    implementation("io.github.ismai117:kottie:2.0.0")
    implementation("org.gradle:gradle-tooling-api:8.10.2")
    implementation("org.slf4j:slf4j-simple:1.7.32") // Simple SLF4J binding for console logging
}

val godotVersion = "4.2.2"
val godotKotlinVersion = "0.9.0"

val godotOs = when {
    OperatingSystem.current().isWindows -> "win64"
    OperatingSystem.current().isMacOsX -> "macos"
    else -> "x11"   // Linux or BSD
}

val godotExecutableName = when {
    OperatingSystem.current().isWindows -> "godot.windows.editor.x86_64.exe"
    OperatingSystem.current().isMacOsX -> "godot.macos.editor.x86_64"
    else -> "godot.linuxbsd.editor.x86_64"
}

val godotFolderName = "godot-kotlin-jvm_editor_x11_$godotKotlinVersion-$godotVersion"
val godotPath = "${System.getProperty("user.home")}/.godot-kotlin/$godotFolderName"
val godotExecutablePath = "$godotPath/$godotExecutableName"

tasks.register("downloadGodot") {
    doLast {
        val godotFile = File(godotExecutablePath)
        if (!godotFile.exists()) {
            val url = "https://github.com/utopia-rise/godot-kotlin-jvm/releases/download/$godotKotlinVersion-$godotVersion/godot-kotlin-jvm_editor_${godotOs}_$godotKotlinVersion-$godotVersion.zip"

            println("Downloading Godot with Kotlin bindings...")
            URL(url).openStream().use { input ->
                ZipInputStream(input).use { zip ->
                    var entry = zip.nextEntry
                    while (entry != null) {
                        val filePath = File(godotPath, entry.name)
                        if (!entry.isDirectory) {
                            filePath.parentFile.mkdirs()
                            filePath.outputStream().use {   output ->
                                zip.copyTo(output)
                            }
                        }
                        entry = zip.nextEntry
                    }
                }
            }
            println("Godot with Kotlin bindings has been downloaded and extracted.")

            if (!OperatingSystem.current().isWindows)
                godotFile.setExecutable(true)
            else
                println("Godot with Kotlin bindings is already installed.")
        }
    }
}

tasks.register("launchGodot") {
    dependsOn("downloadGodot")
    doLast {
        val godotFile = file(godotExecutablePath)
        if (!godotFile.exists()) {
            throw GradleException("Godot executable not found. Please run the downloadGodot task first.")
        }

        val scene = project.findProperty("scene") as String?
        val command = mutableListOf(godotExecutablePath, "--path", projectDir.absolutePath)
        if (scene != null) {
            println("Launching Godot with scene: $scene")
            command.add(scene)
        } else {
            println("Launching Godot without a specific scene")
        }

        exec {
            commandLine(command)
            workingDir = projectDir
        }
    }
}

godot {
    registrationFileBaseDir.set(projectDir.resolve("scripts"))
    isRegistrationFileHierarchyEnabled.set(true)

	// To enable Android Export.
    //isAndroidExportEnabled.set(true) 
	
	// To enable iOS export and Graal Native Image export.
    //isGraalNativeImageExportEnabled.set(true)
}