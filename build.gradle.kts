plugins {
    kotlin("jvm") version "1.9.23"
    id("com.utopia-rise.godot-kotlin-jvm") version "0.9.0-4.2.2"
    id("org.jetbrains.compose") version "1.6.11"

}

repositories {
    mavenLocal()
    mavenCentral()
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.skiko:skiko-awt-runtime-linux-x64:0.8.12")
    implementation("io.github.ismai117:kottie:2.0.0")
}

godot {
    registrationFileBaseDir.set(projectDir.resolve("scripts"))
    isRegistrationFileHierarchyEnabled.set(true)
	
	// To enable Android Export.
    //isAndroidExportEnabled.set(true) 
	
	// To enable iOS export and Graal Native Image export.
    //isGraalNativeImageExportEnabled.set(true)
}