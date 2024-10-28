extends Node2D


# Called when the node enters the scene tree for the first time.
func _ready():
	$AnimationPlayer.play("fade_in_out")
	await get_tree().create_timer(7).timeout
	get_tree().change_scene_to_file("res://scenes/menu.tscn")
