package godot

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.NodePath
import godot.core.StringName
import godot.core.Vector2

@RegisterClass
class Player: CharacterBody2D() {

	private val speed = 100.0
	private var currentDirection = "none"
	private lateinit var animation: AnimatedSprite2D

	@RegisterFunction
	override fun _physicsProcess(delta: Double) {
		playerMovement(delta)
	}

	@RegisterFunction
	override fun _ready() {
		animation = getNode(NodePath("AnimatedSprite2D")) as AnimatedSprite2D
		animation.play(StringName("front_idle"))
	}

	@RegisterFunction
	fun playerMovement(delta: Double) {
		var directionVector = Vector2.ZERO

		when {
			Input.isActionPressed(StringName("ui_right")) -> {
				currentDirection = "right"
				directionVector.x = speed
			}
			Input.isActionPressed(StringName("ui_left")) -> {
				currentDirection = "left"
				directionVector.x = -speed
			}
			Input.isActionPressed(StringName("ui_up")) -> {
				currentDirection = "up"
				directionVector.y = -speed
			}
			Input.isActionPressed(StringName("ui_down")) -> {
				currentDirection = "down"
				directionVector.y = speed
			}
			else -> {
				playAnimation(0)
			}
		}

		if (directionVector != Vector2.ZERO) {
			playAnimation(1)
		} else {
			playAnimation(0)
		}

		velocity = directionVector // Set velocity with Vector2
		moveAndSlide() // Move the player with the calculated velocity

		sendPlayerPositionToServer()
	}

	@RegisterFunction
	fun sendPlayerPositionToServer() {
		val position = globalPosition
		val positionMessage = "updatePosition:${position.x.toInt()},${position.y.toInt()}"

		val webSocketServer = getNode(NodePath("/root/ServerSocket")) as WebSocketServer
		webSocketServer.sendMessage(positionMessage)
	}

	@RegisterFunction
	fun playAnimation(movement: Int) {
		when (currentDirection) {
			"right" -> {
				animation.flipH = false
				animation.play(if (movement == 1) StringName("side_walk") else StringName("side_idle"))
			}
			"left" -> {
				animation.flipH = true
				animation.play(if (movement == 1) StringName("side_walk") else StringName("side_idle"))
			}
			"up" -> {
				animation.flipH = false
				animation.play(if (movement == 1) StringName("back_walk") else StringName("back_idle"))
			}
			"down" -> {
				animation.flipH = false
				animation.play(if (movement == 1) StringName("front_walk") else StringName("front_idle"))
			}
		}
	}
}
