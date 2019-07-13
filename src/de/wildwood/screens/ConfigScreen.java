package de.wildwood.screens;

import java.util.ArrayList;
import java.util.function.Consumer;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.CheckBox;
import de.gurkenlabs.litiengine.gui.DropdownListField;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.gui.HorizontalSlider;
import de.gurkenlabs.litiengine.gui.ImageComponent;
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

		ArrayList<ConfigComponent<?>> coll = new ArrayList<ConfigComponent<?>>();

		coll.add(new ConfigComponent<TextFieldComponent>("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent<TextFieldComponent>("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent<TextFieldComponent>("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent<TextFieldComponent>("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));
		coll.add(new ConfigComponent<TextFieldComponent>("FPS", new TextFieldComponent(0, 0, menuPosX * 2, menuPosY, null, "string")));

		String[] content = { "Cheese", "Pepperoni", "Black Olives" };
		coll.add(new ConfigComponent<DropdownListField>("FPS", new DropdownListField(0, 0, menuPosX * 2, menuPosY, content, 1)));
		
		coll.add(new ConfigComponent<NumberAdjuster>("Numb",
				new NumberAdjuster(0, 0, menuPosX * 2, menuPosY, null, null, 10, 300, 60, 5)));
		coll.add(new ConfigComponent<CheckBox>("CheckBox", new CheckBox(0, 0, menuPosX * 2, menuPosY, null, false)));
		coll.add(new ConfigComponent<CheckBox>("CheckBox", new CheckBox(0, 0, menuPosX * 2, menuPosY, null, false)));
		coll.add(new ConfigComponent<CheckBox>("CheckBox", new CheckBox(0, 0, menuPosX * 2, menuPosY, null, false)));
		coll.add(new ConfigComponent<ImageComponent>("Not Saved", new ImageComponent(0, 0, menuPosX * 2, menuPosY, null, "Save & exit", null)));
		

		for (int i = 0; i < coll.size(); i++) {
			coll.get(i).setup(i, coll.size());
			this.getComponents().add((GuiComponent) coll.get(i).getValueGuiComponent());
			this.getComponents().add(coll.get(i).getTextGuiComponent());
		}
	}

	private class ConfigComponent<GuiComponentType>{
		String displayname;
		int number;
		GuiComponentType valueGuiComponent;
		ImageComponent textGuiComponent;

		public ConfigComponent(String displayname, GuiComponentType valueGuiComponent) {
			this.displayname = displayname;
			this.valueGuiComponent = valueGuiComponent;
			
		}

		@Override
		public String toString() {
			return displayname;

		}
		
		public ConfigComponent<GuiComponentType> onClicked(Consumer<String> consumer) {
			return this;
		}

		public void setup(int number, int total) {
			this.number = number;
			double menuPosX = Game.window().getWidth() / 6;
			double menuPosY = Game.window().getHeight() / 10;
			((GuiComponent) this.valueGuiComponent).setLocation(menuPosX * 3, menuPosY + (menuPosY * 8 / total) * number);
			((GuiComponent) this.valueGuiComponent).setDimension(menuPosX * 2, menuPosY * 8 / total);
			this.textGuiComponent = new ImageComponent(menuPosX, menuPosY + (menuPosY * 8 / total) * number,
					menuPosX * 2, menuPosY, null, displayname, null);
			this.textGuiComponent.setDimension(menuPosX * 2, menuPosY * 8 / total);

		}

		public GuiComponentType getValueGuiComponent() {
			return valueGuiComponent;
		}

		public GuiComponent getTextGuiComponent() {
			return textGuiComponent;
		}

	}

}
