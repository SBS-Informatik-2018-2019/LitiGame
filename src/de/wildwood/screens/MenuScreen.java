package de.wildwood.screens;

import java.awt.Color;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.wildwood.MenuLogic;

public class MenuScreen extends GameScreen {
	public static final String NAME = "MENU";

	public MenuScreen() {
		super(NAME);
		MenuLogic.init(this);
	}

	@Override
	public void render(final Graphics2D g) {
		super.render(g);
		g.setColor(Color.GREEN);
		TextRenderer.render(g, "Press Enter to start Game", 300, 300);
	}

	
}