package ui

import org.gradle.tooling.GradleConnector
import java.io.File

object GodotLauncher {
    fun launchGodotGame(scene: String? = null) {
        val projectDir = File(".")
        val connection = GradleConnector.newConnector()
            .forProjectDirectory(projectDir)
            .connect()

        try {
            val build = connection.newBuild()
            build.forTasks("launchGodot")
            if (scene != null) {
                build.setEnvironmentVariables(mapOf("GODOT_SCENE" to scene))
            }
            build.run()
        } finally {
            connection.close()
        }
    }
}