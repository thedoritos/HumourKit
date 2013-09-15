package com.humooooour.kit.screen;

import processing.core.PGraphics;

import com.humooooour.kit.HSApp;
import com.humooooour.kit.geom.HSRect;
import com.humooooour.kit.ui.HSMenuLayer;

import static com.humooooour.kit.graphics.HSGraphics.drawBackground;

public class HSTitleScreen extends HSScreen {
	
	private HSMenuLayer mMenuLayer;
	
	public HSTitleScreen(HSApp app, HSRect bounds) {
		super(app, bounds);
		mMenuLayer = new HSMenuLayer(app.getActivity());
	}
	
	@Override
	public void dispose() {
		mMenuLayer.dispose();
	}
	
	@Override
	public void draw(PGraphics g) {
		// get drawing bounds
		HSRect bounds = getBounds();
		// draw background
		drawBackground(g, bounds, 0xFF191970);
		
	}
}
