package com.humooooour.kit.screen;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.humooooour.kit.HSApp;
import com.humooooour.kit.geom.HSRect;

import processing.core.PApplet;
import processing.core.PGraphics;

public class HSScreen {
	
	private HSApp mApp;
	private HSRect mBounds;
	
	public HSScreen(HSApp app, HSRect bounds) {
		mApp = app;
		mBounds =bounds;
	}
	
	public void dispose() {
		
	}
	
	public void update(float dt) {
		
	}
	
	public void draw(PGraphics g) {
		
	}
	
	public boolean handleTouch(MotionEvent touch) {
		return false;
	}
	
	public boolean handleKey(KeyEvent key) {
		return false;
	}
	
	protected HSApp getApp() {
		return mApp;
	}
	
	protected PApplet getPApplet() {
		return mApp.getPApplet();
	}
	
	protected Activity getActivity() {
		return mApp.getActivity();
	}
	
	protected PGraphics getPGraphics() {
		return mApp.getPGraphics();
	}
	
	protected HSRect getBounds() {
		return mBounds;
	}
	
	protected HSRect getContentBounds() {
		HSRect cBounds = new HSRect(mBounds);
		cBounds.offsetTo(0.0f, 0.0f);
		return cBounds;
	}
}
