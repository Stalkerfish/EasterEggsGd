package godot

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.GodotError
import godot.global.GD

@RegisterClass
class WebSocketServer : Node() {
	private val PORT = 8080
	private val tcpServer = TCPServer()
	private var socket: WebSocketPeer? = null

	@RegisterFunction
	override fun _ready() {
		if (tcpServer.listen(PORT) != GodotError.OK) {
			GD.print("Unable to start server.")
			setProcess(false)
		}
	}

	@RegisterFunction
	override fun _process(delta: Double) {
		while (tcpServer.isConnectionAvailable()) {
			val conn = tcpServer.takeConnection()
			if (conn != null) {
				socket = WebSocketPeer()
				socket?.acceptStream(conn)
			}
		}
		socket?.poll()

		if (socket?.getReadyState() == WebSocketPeer.State.STATE_OPEN) {
			while ((socket?.getAvailablePacketCount() ?: 0) > 0) {
				val message = socket?.getPacket()?.getStringFromAscii()
				GD.print("Received message: $message")
				when (message) {
					"Ping" -> sendPong()
					"addOrb" -> addOrb()
				}
			}
		}
	}

	@RegisterFunction
	fun addOrb() {
		socket?.sendText("Hell Orb")
	}

	@RegisterFunction
	override fun _exitTree() {
		socket?.close()
		tcpServer.stop()
	}

	@RegisterFunction
	fun sendPong() {
		socket?.sendText("Pong")
	}
}
