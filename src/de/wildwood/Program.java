package de.wildwood;

import de.wildwood.GameManager.GameState;
import de.wildwood.menu.MenuInput;
import de.wildwood.menu.MenuLogic;
import de.wildwood.screens.ConfigScreen;
import de.wildwood.screens.MainGameScreen;
import de.wildwood.screens.MenuScreen;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;

public class Program {

	public static void main(String[] args) {
		Game.setInfo("gameinfo.xml");
		Game.init();
		Game.window().setIconImage(Resources.images().get("sprites/icon.png"));
		//Game.graphics().setBaseRenderScale(4.001f);
		Game.graphics().setBaseRenderScale(6.001f);
		
		Resources.load("litidata/menu.litidata");
		Resources.load("litidata/game.litidata");
		
		Game.screens().add(new MenuScreen());
		Game.screens().add(new MainGameScreen());
		Game.screens().add(new ConfigScreen());
		
		GameManager.setState(GameState.MENU);
		
		Game.start();

	}
}