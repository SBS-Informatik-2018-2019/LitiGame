package de.wildwood;

import de.gurkenlabs.litiengine.Game;
import de.wildwood.menu.MenuLogic;

public class GameManager {
	public enum GameState {
		INGAME, PAUSED, HELP, MENU;
	}

	private static GameState state;

	public static void setState(GameState state) {
		
		switch (state) {

		case INGAME:
			if (GameManager.state != GameState.INGAME) {
				startIngameState(state);
			}
			return;

		case PAUSED:
			return;

		case HELP:
			return;

		case MENU:
			if (GameManager.state != GameState.MENU) {
				startMenuState(state);
			}
			return;
		}
	}

	private static void startIngameState(GameState previousState) {
		if(previousState == GameState.MENU) {
			MenuLogic.uninit();
			
		}
		PlayerInput.init();
		WildwoodLogic.init();
		Game.screens().display("GAMESCREEN");
		Game.world().loadEnvironment("level1");
		state = GameState.INGAME;
		System.out.println("to" +state.toString());//TODO remove
	}
	
	private static void startMenuState(GameState previousState) {
		if(previousState == null) {
			
		}
		MenuLogic.init();
		Game.screens().display("MENUSCREEN");
		state = GameState.MENU;
		System.out.println("to" +state.toString());//TODO remove
	}
	
}
