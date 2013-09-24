package com.humooooour.kit.ex;

import android.app.Activity;

import com.humooooour.kit.HSLauncher;

public class ExLauncher extends HSLauncher {
	
	@Override
	public Class<? extends Activity> getLaunchActivity() {
		return ExActivity.class;
	}
	
}
