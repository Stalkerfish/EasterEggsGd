package dex

import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object GodotLauncher {
    suspend fun launchGodotGame(scene: String? = null) {
        withContext(Dispatchers.IO) {
            val projectDir = File(".")
            val godotExecutablePath = "${System.getProperty("user.home")}/.godot-kotlin/godot-kotlin-jvm_editor_x11_0.9.0-4.2.2/godot.linuxbsd.editor.x86_64"

            val command = mutableListOf(godotExecutablePath, "--path", projectDir.absolutePath)
            if (scene != null) {
                command.add(scene)
            }

            try {
                val processBuilder = ProcessBuilder(command)
                processBuilder.directory(projectDir)
                val process = processBuilder.start()

                // Optionally, you can handle the process output
                // process.inputStream.bufferedReader().use { reader ->
                //     reader.lines().forEach { println(it) }
                // }
            } catch (e: Exception) {
                println("Error launching Godot: ${e.message}")
            }
        }
    }
}