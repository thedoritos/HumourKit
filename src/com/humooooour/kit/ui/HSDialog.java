package com.humooooour.kit.ui;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

public class HSDialog extends Dialog {
	
	private Activity mActivity;
	
	public HSDialog(int resId, Activity activity) {
		super(activity);
		
		// set properties
		mActivity = activity;
		
		// setup window
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		setCanceledOnTouchOutside(false);
		
		// setup content
		setContentView(resId);
	}
	
	public void dispose() {
		mActivity = null;
	}
	
	@Override
	public void show() {
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				HSDialog.super.show();
			}
		});
	}
	
	@Override
	public void dismiss() {
		mActivity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				HSDialog.super.dismiss();
			}
		});
	}
	
}
