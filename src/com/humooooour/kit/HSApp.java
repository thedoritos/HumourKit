package com.humooooour.kit;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.humooooour.kit.geom.HSRect;
import com.humooooour.kit.screen.HSScreenManager;

import processing.core.PApplet;
import processing.core.PGraphics;

public class HSApp {
	
	private PApplet mApplet;
	private HSRect mBounds;
	
	private HSDevice mDevice;
	private HSScreenManager mScreens;
	
	public HSApp(PApplet pApp, HSRect bounds) {
		mApplet = pApp;
		mBounds = bounds;
		
		mDevice = new HSDevice(getContext());
		mScreens = new HSScreenManager();
	}
	
	public void dispose() {
		mScreens.dispose();
		mDevice.dispose();
		mApplet = null;
	}
	
	public void update(float dt) {
		mScreens.update(dt);
	}
	
	public void draw() {
		// update
		update(1.0f / 45.0f);
		
		// render
		PGraphics g = getPGraphics();
		mScreens.draw(g);
	}
	
	public boolean handleTouch(MotionEvent touch) {
		return false;
	}
	
	public boolean handleKey(KeyEvent key) {
		return false;
	}
	
	public PApplet getPApplet() {
		return mApplet;
	}
	
	public PGraphics getPGraphics() {
		return mApplet.g;
	}
	
	public Activity getActivity() {
		return mApplet;
	}
	
	public Context getContext() {
		return mApplet.getApplicationContext();
	}
	
	public HSDevice getDevice() {
		return mDevice;
	}
	
	protected HSRect getBounds() {
		return mBounds;
	}
	
	protected HSScreenManager getScreenManager() {
		return mScreens;
	}
}
