package de.wildwood.abilities;

import de.gurkenlabs.litiengine.abilities.Ability;
import de.gurkenlabs.litiengine.abilities.AbilityOrigin;
import de.gurkenlabs.litiengine.annotation.AbilityInfo;
import de.gurkenlabs.litiengine.entities.Creature;

@AbilityInfo(cooldown = 200, origin = AbilityOrigin.COLLISIONBOX_CENTER, duration = 100, value = 240)
public class Shoot extends Ability {

	public Shoot(Creature executor) {
		super(executor);

		this.addEffect(new ShootEffect(this));
	}
	
	private class ShootEffect extends ForceEffect() {
		
		
	}

}
