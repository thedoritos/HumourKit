package com.humooooour.kit;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Vibrator;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 * Following permissions are required to use methods in this class.
 * 
 * <uses-permission android:name="android.permission.VIBRATE" />
 * <uses-permission android:name="android.permission.WAKE_LOCK" />
 * 
 * @author TomohiroMatsumura
 *
 */
public class HSDevice {
	
	private static final String TAG = HSDevice.class.getName();
	private static final String ERR_PERMISSION = "Permission denied. Check permissions on AndroidManifest.xml.";
	
	private boolean isVibratorEnabled = false;
	private boolean isWakeLockEnabled = false;
	
	private Vibrator mVibrator;
	
	private HSApp mApp;
	
	public static final long VIBE_DURATION_SHORT = 100;
	public static final long VIBE_DURATION_LONG  = 300;
	
	public HSDevice(Context context) {
		
		mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
		
		// check permissions
		String pkgName = context.getPackageName();
		PackageManager pkgMan = context.getPackageManager();
		int granted = PackageManager.PERMISSION_GRANTED;
		
		isVibratorEnabled = (granted == pkgMan.checkPermission(Manifest.permission.VIBRATE, pkgName));
		isWakeLockEnabled = (granted == pkgMan.checkPermission(Manifest.permission.WAKE_LOCK, pkgName));
	}
	
	public void dispose() {
		
	}
	
	public void runVibrate(long duration) {
		// check permission
		if (!isVibratorEnabled) {
			Log.e(TAG, ERR_PERMISSION);
			return;
		}
		
		mVibrator.vibrate(duration);
	}
	
	public void stopVibrate() {
		// check permission
		if (!isVibratorEnabled) {
			Log.e(TAG, ERR_PERMISSION);
			return;
		}
		
		mVibrator.cancel();
	}
	
	public void setScreenKeepOn(boolean on) {
		
		// check permission
		if (!isWakeLockEnabled) {
			Log.e(TAG, ERR_PERMISSION);
			return;
		}
		
		Window window = mApp.getActivity().getWindow();
		if (on) {
			window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		} else {
			window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
	}
}
