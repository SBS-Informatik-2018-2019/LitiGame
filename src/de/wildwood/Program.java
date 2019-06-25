package de.wildwood;

import de.wildwood.screens.MainGameScreen;
import de.wildwood.screens.MenuScreen;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;

public class Program {

	public static void main(String[] args) {
		Game.setInfo("gameinfo.xml");
		Game.init(args);
		Game.window().setIconImage(Resources.images().get("sprites/icon.png"));
		Game.graphics().setBaseRenderScale(4.001f);

		
		Resources.load("litidata/menu.litidata");
		Resources.load("game.litidata");
		
		MenuInput.init();
		MenuLogic.init();

		
		Game.screens().add(new MenuScreen());
		Game.screens().add(new MainGameScreen());
		
		Game.screens().display("MENUSCREEN");
		
		//Game.world().loadEnvironment("menu");
		Game.start();

	}
}