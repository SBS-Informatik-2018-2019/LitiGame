package de.wildwood;

import de.wildwood.entities.Villain;


import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.environment.CreatureMapObjectLoader;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;

public final class WildwoodLogic {

  private WildwoodLogic() {
  }

  /**
   * Initializes the game logic for the Wildwood game.
   */
  public static void init() {
    
    // we'll use a camera in our game that is locked to the location of the player
    Camera camera = new PositionLockCamera(Player.instance());
    camera.setClampToMap(true);
    Game.world().setCamera(camera);
    
    // set a basic gravity for all levels.
    Game.world().setGravity(120);

    // add default game logic for when a level was loaded
    Game.world().addLoadedListener(e -> {

      // spawn the player instance on the spawn point with the name "enter"
      Spawnpoint enter = e.getSpawnpoint("enter");
      if (enter != null) {
        enter.spawn(Player.instance());
      }
    });
    
    CreatureMapObjectLoader.registerCustomCreatureType(Villain.class);
  }
}