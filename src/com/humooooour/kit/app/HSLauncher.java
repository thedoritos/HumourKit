package com.humooooour.kit.app;

import com.humooooour.kit.R;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public abstract class HSLauncher extends Activity {
	
	// Returns the Activity to launch.
	// Override this method to change the target.
	
	/**
	 * Returns the Activity to launch (the class of Activity in strict).
	 * Override this method to change the target.
	 * 
	 * @return Activity to launch.
	 */
	public abstract Class<?> getLaunchActivity();
	
	/**
	 * Returns the duration until to launch the Activity in milliseconds.
	 * Override this method to change the duration.
	 * 
	 * @return
	 */
	public long getLaunchDuration() {
		return 3000;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Setup activity
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.hs_activity_launcher);
		
		// Run task
		new LaunchApp().execute();
	}
	
	private class LaunchApp extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}
		
		@Override
		protected Void doInBackground(Void... args) {
			// Wait for the duration.
			// Or we can run tasks to setup the app here.
			try {
				Thread.sleep(getLaunchDuration());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			// Launch the first activity
			Intent intent = new Intent(HSLauncher.this, getLaunchActivity());
			startActivity(intent);
			finish();
		}
	}
}
