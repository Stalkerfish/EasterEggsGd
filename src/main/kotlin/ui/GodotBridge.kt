package ui

import java.io.File
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.zip.ZipInputStream

object GodotBridge {
    private const val GODOT_VERSION = "4.2.2"
    private const val GODOT_KOTLIN_VERSION = "0.9.1"
    private val godotExecutableName = when {
        System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win") -> "godot.windows.editor.x86_64.exe"
        System.getProperty("os.name").lowercase(Locale.getDefault()).contains("mac") -> "godot.macos.editor.x86_64"
        else -> "godot.linuxbsd.editor.x86_64"
    }
    private val godotFolderName = "godot-kotlin-jvm_editor_x11_$GODOT_KOTLIN_VERSION-$GODOT_VERSION"
    private val godotPath = Paths.get(System.getProperty("user.home"), ".godot-kotlin", godotFolderName).toString()
    private val godotExecutablePath = Paths.get(godotPath, godotExecutableName).toString()

    private val projectPath: String by lazy {
        Paths.get(".").toAbsolutePath().toString()
    }

    fun launchGodotGame(scene: String? = null) {
        ensureGodotInstalled()

        try {
            val command = mutableListOf(godotExecutablePath, "--path", projectPath)
            scene?.let { command.add(it) }

            val process = ProcessBuilder(command)
                .directory(File(projectPath))
                .redirectErrorStream(true)
                .start()

            // Read the output of the Godot process
            process.inputStream.bufferedReader().use { reader ->
                reader.lines().forEach { line ->
                    println("Godot: $line")
                }
            }

            val exitCode = process.waitFor()
            println("Godot process exited with code $exitCode")
        } catch (e: Exception) {
            println("Failed to launch Godot game: ${e.message}")
            e.printStackTrace()
        }
    }

    private fun ensureGodotInstalled() {
        val godotFile = File(godotExecutablePath)
        if (!godotFile.exists()) {
            println("Godot with Kotlin bindings not found. Do you want to download it? (y/n)")
            val response = readlnOrNull()?.lowercase(Locale.getDefault())
            if (response == "y" || response == "yes") {
                downloadGodot()
            } else {
                throw RuntimeException("Godot with Kotlin bindings is required but not installed.")
            }
        }
    }

    private fun downloadGodot() {
        val os = when {
            System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win") -> "win64"
            System.getProperty("os.name").lowercase(Locale.getDefault()).contains("mac") -> "macos"
            else -> "x11"
        }
        val downloadUrl = "https://github.com/utopia-rise/godot-kotlin-jvm/releases/download/$GODOT_KOTLIN_VERSION-$GODOT_VERSION/godot-kotlin-jvm_editor_${os}_$GODOT_KOTLIN_VERSION-$GODOT_VERSION.zip"

        println("Downloading Godot with Kotlin bindings...")
        URL(downloadUrl).openStream().use { input ->
            ZipInputStream(input).use { zip ->
                var entry = zip.nextEntry
                while (entry != null) {
                    val filePath = Paths.get(godotPath, entry.name)
                    if (!entry.isDirectory) {
                        Files.createDirectories(filePath.parent)
                        Files.copy(zip, filePath)
                    }
                    entry = zip.nextEntry
                }
            }
        }
        println("Godot with Kotlin bindings has been downloaded and extracted.")

        // Make the Godot executable file executable on Unix-like systems
        if (!System.getProperty("os.name").lowercase(Locale.getDefault()).contains("win")) {
            File(godotExecutablePath).setExecutable(true)
        }
    }
}