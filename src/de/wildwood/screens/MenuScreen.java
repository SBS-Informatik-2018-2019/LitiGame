package de.wildwood.screens;

import java.awt.Color;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.wildwood.GameManager;
import de.wildwood.GameManager.GameState;

public class MenuScreen extends Screen {
	public static final String NAME = "MENUSCREEN";

	private ImageComponent start;
	private ImageComponent config;
	private ImageComponent exit;
	private ImageComponent surprise;
	

	public MenuScreen() {
		super(NAME);
	}

	@Override
	protected void initializeComponents() {
		// see de.gurkenlabs.litiengine.gui.* for diffrent components

		Color TEXT_COLOR = Color.WHITE;
		Color HOVER_COLOR = Color.ORANGE;

		double buttonX = Game.window().getWidth() / 2.0D;
		double buttonY = Game.window().getHeight() * 7.0D / 16.0D;
		double buttonWidth = Game.window().getWidth() * 3.0D / 16.0D;
		double buttonHeight = Game.window().getHeight() * 1.0D / 16.0D;
		double buttonPadding = Game.window().getHeight() * 1.0D / 32.0D;

		this.start = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY, buttonWidth, buttonHeight, null, "Play",
				null);
		this.start.onClicked(callback -> GameManager.setState(GameState.INGAME));
		this.start.onHovered(callback -> System.out.println(callback.toString()));

		this.config = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY + buttonHeight + buttonPadding,
				buttonWidth, buttonHeight, null, "CONFIG", null);
		this.config.onClicked(callback -> Game.screens().display("CONFIGSCREEN"));
		this.config.onHovered(callback -> System.out.println(callback));

		this.surprise = new ImageComponent(buttonX - buttonWidth / 2.0D,
				buttonY + (buttonHeight + buttonPadding) * 2.0D, buttonWidth, buttonHeight, null, "Surprise", null);

		this.exit = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY + (buttonHeight + buttonPadding) * 3.0D,
				buttonWidth, buttonHeight, null, "Exit", null);

		this.getComponents().add(this.start);
		
		this.getComponents().add(this.config);
		this.getComponents().add(this.exit);
		this.getComponents().add(this.surprise);
	}

}