package com.humooooour.kit.ex;

import com.humooooour.kit.HSApp;
import com.humooooour.kit.HSMainActivity;
import com.humooooour.kit.geom.HSRect;

public class ExActivity extends HSMainActivity {
	
	protected HSApp createApp() {
		return new ExApp(this, new HSRect(0.0f, 0.0f, displayWidth, displayHeight));
	}
}
