package de.wildwood;

import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;

public class MenuLogic {

	public static void init() {
		MenuInput.init();
	}
	
	public static void uninit() {
		MenuInput.uninit();
		Game.world().unloadEnvironment();
		
	}

	public static void keyReleased(KeyEvent keyevent) {
		if (keyevent.getKeyCode() == KeyEvent.VK_ENTER) {
			
			MenuLogic.uninit();
			
			PlayerInput.init();
			WildwoodLogic.init();
			Game.screens().display("GAMESCREEN");
			Game.world().loadEnvironment("level1");
		}

	}
	
	
	

}
