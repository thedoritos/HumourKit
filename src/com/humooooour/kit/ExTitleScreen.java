package com.humooooour.kit;

import static com.humooooour.kit.graphics.HSGraphics.drawBackground;
import processing.core.PGraphics;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.humooooour.kit.geom.HSRect;
import com.humooooour.kit.graphics.HSColor;
import com.humooooour.kit.screen.HSScreen;
import com.humooooour.kit.ui.HSMenuLayer;

public class ExTitleScreen extends HSScreen implements OnClickListener {
	
	private HSMenuLayer mMenuLayer;
	private int bgColor;
	
	public ExTitleScreen(ExApp app, HSRect bounds) {
		super(app, bounds);
		
		bgColor = HSColor.getRandomColor(0xFF);
		
		// setup UI
		mMenuLayer = new HSMenuLayer(app.getActivity());
		mMenuLayer.setVisible(true);
		
		Button playButton = (Button) mMenuLayer.findViewById(R.id.play);
		playButton.setOnClickListener(this);
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
		drawBackground(g, bounds, bgColor);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.play:
			// inflate play screen
			getApp().beginPlay();
			break;
		default:
			break;
		}
	}
	
	@Override
	public ExApp getApp() {
		return (ExApp) super.getApp();
	}
}
