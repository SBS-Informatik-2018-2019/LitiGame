package de.wildwood.menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;

public class MenuLogic {
	// includes MenuInput
	//TODO cleanup

	private static boolean active;
	private static KeyListener observer;

	public static void init() {
		init_();
	}

	public static void uninit() {
		uninit_();
		Game.world().unloadEnvironment();

	}

	static void keyReleased(KeyEvent keyevent) {
		if (keyevent.getKeyCode() == KeyEvent.VK_ENTER) {
			// GameManager.setState(GameState.INGAME);
		} else if (keyevent.getKeyCode() == KeyEvent.VK_C) {
			Game.screens().display("CONFIGSCREEN");
		}
	}

	public static void init_() {
		if (!active) {
			observer = new KeyListener() {

				@Override
				public void keyTyped(KeyEvent e) {

				}

				@Override
				public void keyReleased(KeyEvent e) {
					MenuLogic.keyReleased(e);
				}

				@Override
				public void keyPressed(KeyEvent e) {

				}
			};
			Input.keyboard().addKeyListener(observer);
			active = true;
		}
	}

	public static void uninit_() {
		if (active) {
			Input.keyboard().removeKeyListener(observer);
		}
	}

}
