package de.wildwood.abilities;

import de.gurkenlabs.litiengine.abilities.Ability;
import de.gurkenlabs.litiengine.abilities.AbilityOrigin;
import de.gurkenlabs.litiengine.abilities.effects.EffectApplication;
import de.gurkenlabs.litiengine.abilities.effects.EffectTarget;
import de.gurkenlabs.litiengine.abilities.effects.ForceEffect;

import de.gurkenlabs.litiengine.annotation.AbilityInfo;

import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.IMobileEntity;
import de.gurkenlabs.litiengine.physics.Force;

@AbilityInfo(cooldown = 200, origin = AbilityOrigin.COLLISIONBOX_CENTER, duration = 100, value = 240)
public class Shoot extends Ability {

	public Shoot(Creature executor) {
		super(executor);

		this.addEffect(new ShootEffect(this));
	}

	private class ShootEffect extends ForceEffect {

		public ShootEffect(Shoot shoot) {
			super(shoot, shoot.getAttributes().getValue().getCurrentValue().intValue(), EffectTarget.ENEMY);
		}

		@Override
		protected Force applyForce(IMobileEntity affectedEntity) {
			// create a new entity bullet
			
			return null;
		}
		
		@Override
		protected boolean hasEnded(final EffectApplication appliance) {
			return super.hasEnded(appliance) || this.isHittingEnemy();
		}
		
		/**
		 * Make sure that the shoot stops when the entity touches a 
		 * collision box of an enemy.
		 * 
		 * @return True if the entity touches a static collision box above it.
		 */
		private boolean isHittingEnemy() {
			
			return false;
		}
		
	}

}
