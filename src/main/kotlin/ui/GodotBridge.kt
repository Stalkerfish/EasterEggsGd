package ui

import kotlinx.coroutines.DelicateCoroutinesApi
import org.gradle.tooling.GradleConnector
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object GodotLauncher {
    @OptIn(DelicateCoroutinesApi::class)
    fun launchGodotGame(scene: String? = null) {
        GlobalScope.launch(Dispatchers.IO) {
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
}