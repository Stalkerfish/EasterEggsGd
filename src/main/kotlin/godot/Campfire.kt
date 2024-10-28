package godot

import godot.annotation.RegisterClass
import godot.annotation.RegisterFunction
import godot.core.NodePath
import godot.core.StringName

@RegisterClass
class Campfire: StaticBody2D() {

	private lateinit var animation: AnimatedSprite2D

	@RegisterFunction
	override fun _ready() {
		animation = getNode(NodePath("AnimatedSprite2D")) as AnimatedSprite2D
		animation.play(StringName("default"))
	}
}
