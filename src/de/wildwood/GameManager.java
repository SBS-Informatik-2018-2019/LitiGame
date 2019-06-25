package de.wildwood;

public class GameManager {
	public enum GameState {
		INGAME, PAUSED, HELP, MENU;
	}

	private static GameState gameState;

	public static void setState(GameState state) {
		gameState = state;

		switch (gameState) {
		
		case INGAME:
			return;
			
		case PAUSED:
			return;
			
		case HELP:
			return;
			
		case MENU:
			return;
		}

	}
}
