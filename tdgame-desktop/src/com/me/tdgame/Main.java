package com.me.tdgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Elemental Tower Defense v0.0.0.0.1 pre-alpha indev";
		cfg.width = 768;
		cfg.height = 384;
		
		new LwjglApplication(new TDGame(), cfg);
	}
}
