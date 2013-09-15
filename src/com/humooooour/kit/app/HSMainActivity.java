package com.humooooour.kit.app;

import com.humooooour.kit.geom.HSRect;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import processing.core.PApplet;

public class HSMainActivity extends PApplet {
	
	private HSApp mApp;
	
	/**
	 * Returns a new instance of HSApp.
	 * Override this method to change the target.
	 * 
	 * @return HSApp to launch.
	 */
	protected HSApp createApp() {
		return new HSApp(this, new HSRect(0.0f, 0.0f, displayWidth, displayHeight));
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		// Setup activity.
		super.onCreate(savedInstanceState);
		getSurfaceView().setId(141421356);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		// Setup app.
		mApp = createApp();
	}
	
	@Override
	public void onDestroy() {
		mApp.dispose();
	}
	
	@Override
	public void setup() {
		// Clear screen only once when launch.
		background(0xFF000000);
		// Check app.
		if (mApp == null) {
			throw new RuntimeException("Application is not set. Call setApp() in onCreate().");
		}
	}
	
	@Override
	public void draw() {
		// Draw app instance.
		mApp.draw();
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent touch) {
		// Handle the event on the app instance.
		// If not handled, then dispatch it to super classes.
		return mApp.handleTouch(touch) || super.dispatchTouchEvent(touch);
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent key) {
		// Handle the event on the app instance.
		// If not handled, then dispatch it to super classes.
		return mApp.handleKey(key) || super.dispatchKeyEvent(key);
	}
}
