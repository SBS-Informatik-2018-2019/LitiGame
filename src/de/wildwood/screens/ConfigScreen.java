package de.wildwood.screens;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.HorizontalSlider;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;;

public class ConfigScreen extends Screen {
	public static final String NAME = "CONFIGSCREEN";
	
	ImageComponent maxfps;
	ImageComponent maxfps_value;
	HorizontalSlider maxfps_setting;
	
	
	
	public ConfigScreen() {
		super(NAME);
	}
	
	@Override
	protected void initializeComponents() {
		this.maxfps = new ImageComponent(100, 100, 100, 50, null, "maxfps",null);
		this.maxfps_value = new ImageComponent(200, 100, 100, 50, null, Integer.toString(Game.config().client().getMaxFps()),null);
		this.maxfps_setting  = new HorizontalSlider(400, 100, 400, 50, 25, 240, 5);
		this.maxfps_setting.onChange(consumer -> maxfps_value.setText(Float.toString(maxfps_setting.getCurrentValue())));
		
		this.getComponents().add(maxfps);
		this.getComponents().add(maxfps_value);
		this.getComponents().add(maxfps_setting);
		
	}
}
