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

            val arguments = mutableListOf<String>()
            if (scene != null) {
                arguments.add("-Pscene=$scene")
            }

            build.withArguments(arguments)
            build.run()
        } finally {
            connection.close()
        }
    }
}