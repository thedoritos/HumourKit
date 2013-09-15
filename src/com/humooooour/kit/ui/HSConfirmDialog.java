package com.humooooour.kit.ui;

import com.humooooour.kit.R;

import android.app.Activity;
import android.widget.TextView;

public class HSConfirmDialog extends HSDialog {

	public HSConfirmDialog(Activity activity) {
		super(R.layout.hs_dialog_confirm, activity);
	}
	
	public HSConfirmDialog setTitle(String text) {
		TextView title = (TextView) findViewById(R.id.title);
		title.setText(text);
		return this;
	}
	
	public HSConfirmDialog setMessage(String text) {
		TextView message = (TextView) findViewById(R.id.message);
		message.setText(text);
		return this;
	}

}
