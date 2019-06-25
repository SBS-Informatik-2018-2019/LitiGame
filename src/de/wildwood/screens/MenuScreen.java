package de.wildwood.screens;

import java.awt.Color;
import java.awt.Font;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

public class MenuScreen extends GameScreen {
	public static final String NAME = "MENUSCREEN";

	private ImageComponent start;
	private ImageComponent exit;
	private ImageComponent help;
	private ImageComponent surprise;

	public MenuScreen() {
		super(NAME);
	}

	protected void initializeComponents() {
		Color TEXT_COLOR = Color.WHITE;
		Color HOVER_COLOR = Color.ORANGE;

		double buttonX = Game.window().getWidth() / 2.0D;
		double buttonY = Game.window().getHeight() * 7.0D / 16.0D;
		double buttonWidth = Game.window().getWidth() * 3.0D / 16.0D;
		double buttonHeight = Game.window().getHeight() * 1.0D / 16.0D;
		double buttonPadding = Game.window().getHeight() * 1.0D / 32.0D;

		this.start = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY, buttonWidth, buttonHeight, null, "Play",
				null);
		//this.start.setColor(TEXT_COLOR);
		//this.start.setHoverTextColor(HOVER_COLOR);
		//this.start.setFont(buttonFont);
		//this.start.onClicked(e -> GameManager.setState(GameManager.GameState.MENUHELP));

		this.help = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY + buttonHeight + buttonPadding, buttonWidth, buttonHeight, null, "Help", null);
		//this.help.setTextColor(TEXT_COLOR);
		//this.help.setHoverTextColor(HOVER_COLOR);
		//this.help.setFont(buttonFont);
		//this.help.onClicked(e -> GameManager.setState(GameManager.GameState.MENUHELP));

		this.surprise = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY + (buttonHeight + buttonPadding) * 2.0D, buttonWidth, buttonHeight, null, "Surprise", null);
		//this.surprise.setTextColor(TEXT_COLOR);
		//this.surprise.setHoverTextColor(HOVER_COLOR);
		//this.surprise.setFont(buttonFont);

		this.exit = new ImageComponent(buttonX - buttonWidth / 2.0D, buttonY + (buttonHeight + buttonPadding) * 3.0D,buttonWidth, buttonHeight, null, "Exit", null);
		//this.exit.setTextColor(TEXT_COLOR);
		//this.exit.setHoverTextColor(HOVER_COLOR);
		//this.exit.setFont(buttonFont);

		getComponents().add(this.start);
		getComponents().add(this.help);
		getComponents().add(this.exit);
		getComponents().add(this.surprise);
	}

}