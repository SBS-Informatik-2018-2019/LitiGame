package de.wildwood;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;
import de.wildwood.screens.MenuScreen;

public class MenuLogic {
	static MenuScreen menuScreen;
	static KeyListener observer;

	public static void init(MenuScreen menuScreen) {
		MenuLogic.menuScreen = menuScreen;
		MenuLogic.observer = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Game.screens().display("INGAME-SCREEN");
					Game.world().loadEnvironment("level1");
					uninit();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		};
		Input.keyboard().addKeyListener(observer);

	}

	public static void uninit() {
		Input.keyboard().removeKeyListener(observer);
	}

}
