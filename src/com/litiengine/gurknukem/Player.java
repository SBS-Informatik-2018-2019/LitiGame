package com.litiengine.gurknukem;

import java.awt.geom.Rectangle2D;

import com.litiengine.gurknukem.abilities.Jump;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.annotation.Action;
import de.gurkenlabs.litiengine.annotation.CollisionInfo;
import de.gurkenlabs.litiengine.annotation.EntityInfo;
import de.gurkenlabs.litiengine.annotation.MovementInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.input.PlatformingMovementController;
import de.gurkenlabs.litiengine.physics.Collision;

@EntityInfo(width = 18, height = 18)
@MovementInfo(velocity = 70)
@CollisionInfo(collisionBoxWidth = 8, collisionBoxHeight = 16, collision = true)
public class Player extends Creature implements IUpdateable {
  public static final int MAX_ADDITIONAL_JUMPS = 1;

  private static Player instance;

  private final Jump jump;

  private int consecutiveJumps;

  private Player() {
    super("gurknukem");

    // setup movement controller
    this.addController(new PlatformingMovementController<>(this));

    // setup the player's abilities
    this.jump = new Jump(this);
  }

  public static Player instance() {
    if (instance == null) {
      instance = new Player();
    }

    return instance;
  }

  @Override
  public void update() {
    // reset the number of consecutive jumps when touching the ground
    if (this.isTouchingGround()) {
      this.consecutiveJumps = 0;
    }
  }

  /**
   * Checks whether this instance can currently jump and then performs the <code>Jump</code> ability.
   * <p>
   * <i>Note that the name of this methods needs to be equal to {@link PlatformingMovementController#JUMP}} in order for the controller to be able to
   * use this method. <br>
   * Another option is to explicitly specify the <code>Action.name()</code> attribute on the annotation.</i>
   * </p>
   */
  @Action(description = "This performs the jump ability for the player's entity.")
  public void jump() {
    if (this.consecutiveJumps >= MAX_ADDITIONAL_JUMPS || !this.jump.canCast()) {
      return;
    }

    this.jump.cast();
    this.consecutiveJumps++;
  }

  private boolean isTouchingGround() {
    // the idea of this ground check is to extend the current collision box by
    // one pixel and see if
    // a) it collides with any static collision box
    Rectangle2D groundCheck = new Rectangle2D.Double(this.getCollisionBox().getX(), this.getCollisionBox().getY(), this.getCollisionBoxWidth(), this.getCollisionBoxHeight() + 1);

    // b) it collides with the map's boundaries
    if (groundCheck.getMaxY() > Game.physics().getBounds().getMaxY()) {
      return true;
    }

    return Game.physics().collides(groundCheck, Collision.STATIC);
  }
}