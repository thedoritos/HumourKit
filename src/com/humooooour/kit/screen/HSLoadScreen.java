package com.humooooour.kit.screen;

import processing.core.PGraphics;

import com.humooooour.kit.app.HSApp;
import com.humooooour.kit.geom.HSRect;

import static com.humooooour.kit.graphics.HSGraphics.drawBackground;

public class HSLoadScreen extends HSScreen {
	
	private String mLoadMessage = "Loading";
	private String mLoadIndicator = ".";
	
	private StringBuilder mMessageBuilder;
	
	private int mLoadCounter = 0;
	private float mLoadTimer = 0.0f;
	
	private static final int LOAD_COUNT_MAX = 5;
	private static final float LOAD_COUNT_INTERVAL = 1.0f;
	
	public HSLoadScreen(HSApp app, HSRect bounds) {
		super(app, bounds);
		mMessageBuilder = new StringBuilder();
	}
	
	@Override
	public void update(float dt) {
		// count up loading time
		mLoadTimer += dt;
		mLoadCounter = (int) (mLoadTimer / LOAD_COUNT_INTERVAL);
		mLoadCounter %= LOAD_COUNT_MAX;
	}
	
	@Override
	public void draw(PGraphics g) {
		// get drawing bounds
		HSRect bounds = getBounds();
		// draw background
		drawBackground(g, bounds, 0xFF800000);
		
		// create load message
		mMessageBuilder.delete(0, mMessageBuilder.length());
		mMessageBuilder.append(mLoadMessage);
		for (int i = 0; i < mLoadCounter; i++) {
			mMessageBuilder.append(mLoadIndicator);
		}
		
		// draw load message
		g.fill(0xFFFFFFF0);
		g.textAlign(PGraphics.CENTER, PGraphics.CENTER);
		g.text(new String(mMessageBuilder), bounds.centerX(), bounds.centerY());
	}
	
	public void setLoadMessage(String text) {
		mLoadMessage = text;
	}
	
	public void setLoadIndicator(String text) {
		mLoadIndicator = text;
	}
	
}
