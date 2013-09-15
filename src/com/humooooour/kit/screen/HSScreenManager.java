package com.humooooour.kit.screen;

import java.util.Deque;
import java.util.LinkedList;

import processing.core.PGraphics;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class HSScreenManager {
	
	private static final String TAG = HSScreenManager.class.getName();
	private static final String ERR_NO_BUFF = "Screen buffer is not ready.";
	
	// Stack of the screens. Only the last screen is
	// drawn, updated, and notified on touch and key events.
	private Deque<HSScreen> mScreenStack;
	
	// The special screen always on the bottom of the stack,
	// and not will be removed automatically.
	// For example, we can set Loading Screen on this so that
	// it will be displayed when other screens are disposed
	private HSScreen mBaseScreen;
	
	private HSScreen mScreenBuffer;
	
	public HSScreenManager() {
		mScreenStack = new LinkedList<HSScreen>();
		mBaseScreen = null;
		mScreenBuffer = null;
	}
	
	public HSScreenManager(HSScreen baseScreen) {
		this();
		setBaseScreen(baseScreen);
	}
	
	public void setBaseScreen(HSScreen screen) {
		
		// clear previous
		if (mBaseScreen != null) {
			// stop draw, update and etc.
			mScreenStack.remove(mBaseScreen);
			
			// dispose
			mBaseScreen.dispose();
			mBaseScreen = null;
		}
		
		// set new
		mBaseScreen = screen;
		mScreenStack.addFirst(mBaseScreen);
	}
	
	public void setBuffer(HSScreen screen) {
		// clear previous
		if (mScreenBuffer != null) {
			mScreenBuffer.dispose();
			mScreenBuffer = null;
		}
		// set new
		mScreenBuffer = screen;
	}
	
	public void loadBuffer() {
		// check buffer
		if (mScreenBuffer == null) {
			Log.e(TAG, ERR_NO_BUFF);
			return;
		}
		// bring buffer forward
		mScreenStack.add(mScreenBuffer);
		mScreenBuffer = null;
	}
	
	public void replaceWithBuffer() {
		// check buffer
		if (mScreenBuffer == null) {
			Log.e(TAG, ERR_NO_BUFF);
			return;
		}
		
		// delete current screen
		if (!mScreenStack.isEmpty()) {
			
			if (mBaseScreen != null && mBaseScreen.equals(mScreenStack.getLast())) {
				// do not remove the base screen
			} else {
				// remove current screen
				HSScreen current = mScreenStack.removeLast();
				current.dispose();
			}
		}
		
		// bring buffer forward
		mScreenStack.add(mScreenBuffer);
		mScreenBuffer = null;
	}
	
	public void dispose() {
		while (!mScreenStack.isEmpty()) {
			HSScreen screen = mScreenStack.removeFirst();
			screen.dispose();
		}
	}
	
	public void update(float dt) {
		if (!mScreenStack.isEmpty()) {
			mScreenStack.getLast().update(dt);
		}
	}
	
	public void draw(PGraphics g) {
		if (!mScreenStack.isEmpty()) {
			mScreenStack.getLast().draw(g);
		}
	}
	
	public boolean handleTouch(MotionEvent touch) {
		if (!mScreenStack.isEmpty()) {
			return mScreenStack.getLast().handleTouch(touch);
		} else {
			return false;
		}
	}
	
	public boolean handleKey(KeyEvent key) {
		if (!mScreenStack.isEmpty()) {
			return mScreenStack.getLast().handleKey(key);
		} else {
			return false;
		}
	}
}
