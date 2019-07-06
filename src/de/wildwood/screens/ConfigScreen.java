package de.wildwood.screens;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Iterator;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.CheckBox;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.gui.HorizontalSlider;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.DropdownListField;
import de.gurkenlabs.litiengine.gui.NumberAdjuster;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;;

public class ConfigScreen extends Screen {
	public static final String NAME = "CONFIGSCREEN";

	TextFieldComponent maxfps;
	NumberAdjuster maxfps_value;
	HorizontalSlider maxfps_setting;

	public ConfigScreen() {
		super(NAME);
	}

	@Override
	protected void initializeComponents() {
		double menuPosX = Game.window().getWidth() / 6;
		double menuPosY = Game.window().getHeight() / 10;

		ArrayList<ConfigScreen.ConfigComponent> coll = new ArrayList<ConfigScreen.ConfigComponent>();

		coll.add(new ConfigComponent("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));

		String[] content = { "Cheese", "Pepperoni", "Black Olives" };
		coll.add(new ConfigComponent("FPS", new DropdownListField(0, 0, menuPosX * 2, menuPosY, content, 1)));
		
		coll.add(new ConfigComponent("Numb",
				new NumberAdjuster(0, 0, menuPosX * 2, menuPosY, null, null, 10, 300, 60, 5)));
		coll.add(new ConfigComponent("CheckBox", new CheckBox(0, 0, menuPosX * 2, menuPosY, null, false)));
		coll.add(new ConfigComponent("CheckBox", new CheckBox(0, 0, menuPosX * 2, menuPosY, null, false)));
		coll.add(new ConfigComponent("CheckBox", new CheckBox(0, 0, menuPosX * 2, menuPosY, null, false)));

		for (int i = 0; i < coll.size(); i++) {
			coll.get(i).setup(i, coll.size());
			this.getComponents().add(coll.get(i).getValueGuiComponent());
			this.getComponents().add(coll.get(i).getTextGuiComponent());
		}
	}

	private class ConfigComponent {
		String displayname;
		int number;
		GuiComponent valueGuiComponent;
		ImageComponent textGuiComponent;

		public ConfigComponent(String displayname, GuiComponent valueGuiComponent) {
			this.displayname = displayname;
			this.valueGuiComponent = valueGuiComponent;
		}

		@Override
		public String toString() {
			return displayname;

		}

		public void setup(int number, int total) {
			this.number = number;
			double menuPosX = Game.window().getWidth() / 6;
			double menuPosY = Game.window().getHeight() / 10;
			this.valueGuiComponent.setLocation(menuPosX * 3, menuPosY + (menuPosY * 8 / total) * number);
			this.valueGuiComponent.setDimension(menuPosX * 2.5f, menuPosY * 8 / total);
			this.textGuiComponent = new ImageComponent(menuPosX, menuPosY + (menuPosY * 8 / total) * number,
					menuPosX * 2, menuPosY, null, displayname, null);
			this.textGuiComponent.setDimension(menuPosX * 2, menuPosY * 8 / total);

		}

		public GuiComponent getValueGuiComponent() {
			return valueGuiComponent;
		}

		public GuiComponent getTextGuiComponent() {
			return textGuiComponent;
		}

	}

}
