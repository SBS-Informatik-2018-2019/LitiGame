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
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.NumberAdjuster;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;;

public class ConfigScreen extends Screen {
	public static final String NAME = "CONFIGSCREEN";

	de.gurkenlabs.litiengine.gui.Menu menu;
	

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

		coll.add(new ConfigComponent("FPS", new TextFieldComponent(0, 0, 0, 0, null, "string")));
		coll.add(new ConfigComponent("NumberAdju", new NumberAdjuster(0, 0, 0, 0, null, null, 10, 300, 60, 5)));
		coll.add(new ConfigComponent("CheckBox", new CheckBox(0, 0, 0, 0, null, false)));

		this.menu = new Menu(menuPosX, menuPosY, menuPosX*2, menuPosY * 8, coll.get(0).toString(), coll.get(1).toString(),coll.get(2).toString());
		menu.onClicked(callback -> {
			System.out.println(menu.getCurrentSelection() + " clicked config");
		});

		/*
		 * this.maxfps = new TextFieldComponent(100, 100, 100, 50, null, "maxfps");
		 * this.maxfps_value = new NumberAdjuster(200, 100, 100, 50, null, null, 10,
		 * 300, Game.config().client().getMaxFps(), 5);
		 * this.maxfps_value.onValueChange(consumer -> {
		 * Game.config().client().setMaxFps(consumer.intValue()); });
		 * this.maxfps_value.onChangeConfirmed(consumer -> {
		 * this.maxfps_value.setCurrentValue(new BigDecimal(new
		 * BigDecimal(consumer).intValue())); Game.config().client().setMaxFps(new
		 * BigDecimal(consumer).intValue()); });
		 */
		// this.maxfps_setting = new HorizontalSlider(400, 100, 400, 50, 25, 240, 5);
		// this.maxfps_setting.onChange(consumer ->
		// maxfps_value.setText(Float.toString(maxfps_setting.getCurrentValue())));

		this.getComponents().add(menu);
		for (int i = 0; i < coll.size(); i++) {
			coll.get(i).setup(i, coll.size());
			this.getComponents().add(coll.get(i).getGuiComponent());
		}

		// this.getComponents().add(maxfps);
		// this.getComponents().add(maxfps_value);

		// this.getComponents().add(maxfps_setting);

	}

	private class ConfigComponent {
		String displayname;
		int number;
		GuiComponent guiComponent;

		public ConfigComponent(String displayname, GuiComponent guiComponent) {
			this.displayname = displayname;
			this.guiComponent = guiComponent;
			//this.guiComponent.setEnabled(false);
			//this.guiComponent.setVisible(false);

		}

		@Override
		public String toString() {
			return displayname;

		}

		public void setup(int number, int total) {
			this.number = number;
			double menuPosX = Game.window().getWidth() / 6;
			double menuPosY = Game.window().getHeight() / 10;
			this.guiComponent.setLocation(menuPosX * 3, menuPosY + (menuPosY * 8 / total) * number);
			this.guiComponent.setDimension(menuPosX*2.5f, menuPosY * 8 / total);
		
		
		}

		public GuiComponent getGuiComponent() {
			return guiComponent;
		}

	}

}
