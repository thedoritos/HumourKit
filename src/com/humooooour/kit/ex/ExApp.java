package com.humooooour.kit.ex;

import processing.core.PApplet;

import com.humooooour.kit.HSApp;
import com.humooooour.kit.geom.HSRect;
import com.humooooour.kit.screen.HSLoadScreen;
import com.humooooour.kit.screen.HSScreenManager;

public class ExApp extends HSApp {
	
	public ExApp(PApplet pApp, HSRect bounds) {
		super(pApp, bounds);
		
		HSScreenManager manager = getScreenManager();
		manager.setBaseScreen(new HSLoadScreen(this, getBounds()));
		
		beginTitle();
	}
	
	public void beginTitle() {
		HSScreenManager manager = getScreenManager();
		manager.setBuffer(new ExTitleScreen(this, getBounds()));
		manager.replaceWithBuffer();
	}
	
	public void beginPlay() {
		HSScreenManager manager = getScreenManager();
		manager.setBuffer(new ExGameScreen(this, getBounds()));
		manager.replaceWithBuffer();
	}
	
	public void endPlay() {
		beginTitle();
	}
	
}
