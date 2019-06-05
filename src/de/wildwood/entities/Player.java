package de.wildwood.entities;

import com.litiengine.gurknukem.entities.EnemyController;

import de.gurkenlabs.litiengine.annotation.AnimationInfo;
import de.gurkenlabs.litiengine.annotation.EntityInfo;
import de.gurkenlabs.litiengine.entities.Creature;

@EntityInfo(width = 18, height = 18)
@AnimationInfo(spritePrefix = "jorge")
public class Player extends Creature {

	
	public Player() {
		this.addController(new EnemyController(this));
	}

}
