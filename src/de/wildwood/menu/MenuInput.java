package de.wildwood.menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.gurkenlabs.litiengine.input.Input;

public class MenuInput {
	private static boolean active;
	private static KeyListener observer;

	public static void init() {
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

	public static void uninit() {
		if (active) {
			Input.keyboard().removeKeyListener(observer);
		}
	}

}
