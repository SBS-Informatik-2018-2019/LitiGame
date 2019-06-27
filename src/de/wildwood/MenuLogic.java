package de.wildwood;

import java.awt.event.KeyEvent;

import de.gurkenlabs.litiengine.Game;
import de.wildwood.GameManager.GameState;

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
			GameManager.setState(GameState.INGAME);
		}
	}
	
	
	

}
