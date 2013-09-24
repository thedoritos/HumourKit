package com.humooooour.kit.ex;

import processing.core.PGraphics;
import processing.core.PVector;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//import com.humooooour.kit.app.HSDevice;
import com.humooooour.kit.R;
import com.humooooour.kit.geom.HSRect;
import com.humooooour.kit.graphics.HSColor;
import com.humooooour.kit.screen.HSScreen;
import com.humooooour.kit.ui.HSLayer;

import static com.humooooour.kit.graphics.HSGraphics.drawBackground;

public class ExGameScreen extends HSScreen implements OnClickListener{
	
	private HSLayer uiLayer;
	private int bgColor;
	
	private PVector mBallPos;
	private PVector mBallVel;
	private float mBallSpeed;
	
	private boolean mIsPlaying = false;
	
	public ExGameScreen(ExApp app, HSRect bounds) {
		super(app, bounds);
		
		bgColor = HSColor.getRandomColor(0xFF);
		
		// setup ui
		uiLayer = new HSLayer(R.layout.hs_layer_game, getActivity());
		uiLayer.setVisible(true);
		
		Button playButton = (Button) uiLayer.findViewById(R.id.play);
		playButton.setOnClickListener(this);
		Button pauseButton = (Button) uiLayer.findViewById(R.id.pause);
		pauseButton.setOnClickListener(this);
		Button exitButton = (Button) uiLayer.findViewById(R.id.exit);
		exitButton.setOnClickListener(this);
		
		// set ball properties
		mBallPos = new PVector(bounds.centerX(), bounds.centerY());
		
		double velAngle = Math.random() * Math.PI * 2;
		mBallVel = new PVector((float) Math.cos(velAngle), (float) Math.sin(velAngle));
		mBallSpeed = 100.0f;
	}
	
	@Override
	public void dispose() {
		uiLayer.dispose();
	}
	
	@Override
	public void update(float dt) {
		
		// do not update while not playing
		if (!mIsPlaying) return;
		
		// update ball
		PVector posDiff = PVector.mult(mBallVel, mBallSpeed * dt);
		mBallPos.add(posDiff);
		
		// update velocity when bounce
		HSRect bounds = getBounds();
		if (mBallPos.x < bounds.left || mBallPos.x > bounds.right) {
			mBallPos.sub(posDiff);
			mBallVel.x *= -1.0f;
//			vibrate();
		}
		
		if (mBallPos.y < bounds.top || mBallPos.y > bounds.bottom) {
			mBallPos.sub(posDiff);
			mBallVel.y *= -1.0f;
//			vibrate();
		}
	}
	
//	private void vibrate() {
//		getApp().getDevice().runVibrate(HSDevice.VIBE_DURATION_SHORT);
//	}
	
	@Override
	public void draw(PGraphics g) {
		// get drawing bounds
		HSRect bounds = getBounds();
		// draw background
		drawBackground(g, bounds, bgColor);
		
		// draw ball
		g.stroke(0xFFFFFF);
		g.fill(0x88000000);
		g.ellipseMode(PGraphics.CENTER);
		g.ellipse(mBallPos.x, mBallPos.y, 10.0f, 10.0f);
	}

	@Override
	public void onClick(View v) {
		
		if (v.getId() == R.id.play) {
			mIsPlaying = true;
			
		} else if (v.getId() == R.id.pause) {
			mIsPlaying = false;
			
		} else if (v.getId() == R.id.exit) {
			// exit screen
			getApp().endPlay();
		}
	}
	
	@Override
	public ExApp getApp() {
		return (ExApp) super.getApp();
	}
}
