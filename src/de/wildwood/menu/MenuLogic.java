package de.wildwood.menu;

import java.awt.event.KeyEvent;
import java.util.List;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.configuration.ConfigurationGroup;
import de.wildwood.GameManager;
import de.wildwood.GameManager.GameState;

public class MenuLogic {

	public static void init() {
		MenuInput.init();
	}
	
	public static void uninit() {
		MenuInput.uninit();
		Game.world().unloadEnvironment();
		
	}

	static void keyReleased(KeyEvent keyevent) {
		if (keyevent.getKeyCode() == KeyEvent.VK_ENTER) {
			GameManager.setState(GameState.INGAME);
		}else if (keyevent.getKeyCode() == KeyEvent.VK_C) {
			
		}
	}
	
	
	
	
	
	
	

}
