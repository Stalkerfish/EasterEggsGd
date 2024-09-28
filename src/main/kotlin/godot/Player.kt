package godot

import godot.CharacterBody2D
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

	// Called when the node enters the scene tree for the first time.
	@RegisterFunction
	override fun _ready() {
		animation = getNode(NodePath("AnimatedSprite2D")) as AnimatedSprite2D
		animation.play(StringName("front_idle"))
	}

	@RegisterFunction
	fun playerMovement(delta: Double) {
		var directionVector = Vector2.ZERO

		if (Input.isActionPressed(StringName("ui_right"))) {
			currentDirection = "right"
			playAnimation(1)
			directionVector.x = speed
		}
		else if (Input.isActionPressed(StringName("ui_left"))) {
			currentDirection = "left"
			playAnimation(1)
			directionVector.x = -speed
		}
		else if (Input.isActionPressed(StringName("ui_up"))) {
			currentDirection = "up"
			playAnimation(1)
			directionVector.y = -speed
		}
		else if (Input.isActionPressed(StringName("ui_down"))) {
			currentDirection = "down"
			playAnimation(1)
			directionVector.y = speed
		}
		else {
			playAnimation(0)
		}

		velocity = directionVector // Set velocity with Vector2
		moveAndSlide() // Move the player with the calculated velocity
	}

	@RegisterFunction
	fun playAnimation(movement: Int) {
		val direction = currentDirection

		when (direction) {
			"right" -> {
				animation.flipH = false
				if (movement == 1)
					animation.play(StringName("side_walk"))
				else
					animation.play(StringName("side_idle"))
			}

			"left" -> {
				animation.flipH = true
				if (movement == 1)
					animation.play(StringName("side_walk"))
				else
					animation.play(StringName("side_idle"))
			}

			"up" -> {
				animation.flipH = false
				if (movement == 1)
					animation.play(StringName("back_walk"))
				else
					animation.play(StringName("back_idle"))
			}

			"down" -> {
				animation.flipH = false
				if (movement == 1)
					animation.play(StringName("front_walk"))
				else
					animation.play(StringName("front_idle"))
			}
		}
	}
}
