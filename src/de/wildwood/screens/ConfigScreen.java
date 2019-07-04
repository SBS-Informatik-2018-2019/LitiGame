package de.wildwood.screens;

import java.math.BigDecimal;
import java.math.MathContext;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.HorizontalSlider;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.NumberAdjuster;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;;

public class ConfigScreen extends Screen {
	public static final String NAME = "CONFIGSCREEN";

	de.gurkenlabs.litiengine.gui.Menu menu;
	de.gurkenlabs.litiengine.gui.ImageComponentList imgcomplist;

	TextFieldComponent maxfps;
	NumberAdjuster maxfps_value;
	HorizontalSlider maxfps_setting;

	public ConfigScreen() {
		super(NAME);
	}

	@Override
	protected void initializeComponents() {
		double menuPosX = Game.window().getWidth() / 4;
		double menuPosY = Game.window().getHeight() / 10;

		this.menu = new Menu(menuPosX, menuPosY, menuPosX * 2, menuPosY * 8, "FPS", "QUALITÄT", "...");
		menu.onClicked(callback -> {
			menu.getCurrentSelection();
		});

		/*this.maxfps = new TextFieldComponent(100, 100, 100, 50, null, "maxfps");
		this.maxfps_value = new NumberAdjuster(200, 100, 100, 50, null, null, 10, 300,
				Game.config().client().getMaxFps(), 5);
		this.maxfps_value.onValueChange(consumer -> {
			Game.config().client().setMaxFps(consumer.intValue());
		});
		this.maxfps_value.onChangeConfirmed(consumer -> {
			this.maxfps_value.setCurrentValue(new BigDecimal(new BigDecimal(consumer).intValue()));
			Game.config().client().setMaxFps(new BigDecimal(consumer).intValue());
		});
		*/
		// this.maxfps_setting = new HorizontalSlider(400, 100, 400, 50, 25, 240, 5);
		// this.maxfps_setting.onChange(consumer ->
		// maxfps_value.setText(Float.toString(maxfps_setting.getCurrentValue())));

		this.getComponents().add(menu);

		// this.getComponents().add(maxfps);
		// this.getComponents().add(maxfps_value);

		// this.getComponents().add(maxfps_setting);

	}
}
