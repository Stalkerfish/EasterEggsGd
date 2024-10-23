package dex

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okio.ByteString

val client = OkHttpClient()
private var webSocket: WebSocket? = null

private var isConnected = false

const val serverIP = "192.168.0.204"
const val port = "8080"

fun connectWebSocket(onNavigate: (Room) -> Unit) {
    if (!isConnected) {
        val request = Request.Builder().url("ws://${serverIP}:${port}").build()
        val webSocketListener = object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: okhttp3.Response) {
                webSocket.send("Ping")
                 isConnected = true
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                println("Received message: $text")
                if (text == "Hell Orb"){
                    val orb = Orb(Room.Hell, Room.Hell.name, onNavigate)
                    addItemToInventory(orb)
                }
            }

            override fun onMessage(webSocket: WebSocket, bytes: ByteString) {
                println("Received bytes: ${bytes.hex()}")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: okhttp3.Response?) {
                t.printStackTrace()
                isConnected = false
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                    println("WebSocket Closed")
                    isConnected = false
            }
        }

        webSocket = client.newWebSocket(request, webSocketListener)
    }
    else println("WebSocket already connected")
}

fun sendMessage(message: String) {
    webSocket?.send(message)
}

fun disconnectWebSocket() {
    webSocket?.close(1000, "Disconnected by user")
    isConnected = false
    println("WebSocket Disconnected")
}

fun addItemToInventory(item: Item) {
    val items = HomeInventory.homeInventory.getItems()
    items.add(item)
}
