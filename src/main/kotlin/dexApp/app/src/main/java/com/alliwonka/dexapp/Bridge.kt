package com.alliwonka.dexapp

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.ws
import io.ktor.websocket.Frame
import io.ktor.websocket.readReason
import io.ktor.websocket.readText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val webSocketClient = HttpClient(CIO) {
    install(WebSockets)
}
private const val host = "192.168.0.204"
private const val WEB_SOCKET_URL = "ws://${host}:8080/connect"

fun connectWebSocket(lifecycleScope: CoroutineScope) {
    lifecycleScope.launch { // Use viewModelScope or lifecycleScope
        try {
            webSocketClient.ws(urlString = WEB_SOCKET_URL) {
                println("WebSocket connection opened")
                send(frame = Frame.Text("PuzzleSolved"))

                for (frame in incoming) {
                    when (frame) {
                        is Frame.Text -> {
                            val message = frame.readText()
                            println("Server says: $message")
                        }
                        is Frame.Binary -> {
                            println("Received binary frame")
                            // Handle binary frames as needed
                        }
                        is Frame.Close -> {
                            println("WebSocket connection closed: ${frame.readReason()}")
                        }
                        else -> println("Received unexpected frame type: ${frame.frameType}")
                    }
                }

                outgoing.invokeOnClose { cause ->
                    println("WebSocket connection closed:${cause?.message}")
                }
            }
        } catch (e: Exception) {
            println("WebSocket error: ${e.message}")
        }
    }
}