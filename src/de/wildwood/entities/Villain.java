package de.wildwood.entities;

import de.wildwood.entities.EnemyController;

import de.gurkenlabs.litiengine.annotation.AnimationInfo;
import de.gurkenlabs.litiengine.annotation.EntityInfo;
import de.gurkenlabs.litiengine.entities.Creature;

@EntityInfo(width = 18, height = 18)
@AnimationInfo(spritePrefix = "jorge")
public class Villain extends Creature {

	
	public Villain() {
		this.addController(new EnemyController(this));
	}

}
