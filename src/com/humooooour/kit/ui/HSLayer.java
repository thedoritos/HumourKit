package com.humooooour.kit.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import com.humooooour.kit.geom.HSRect;

/**
 * Wrapper class of android.view.View.
 * Call the constructor to create new View on the Activity.
 * Do not forget to call dispose() to delete the View. Note
 * that the instance is expired and any API must not be called
 * once you have called dispose().
 * 
 * @author thedoritos
 * @version 2013.09.12
 */
public class HSLayer {
	
	private View mView;
	
	public HSLayer(int resId, Activity activity) {
		mView = activity.getLayoutInflater().inflate(resId, null);
		activity.addContentView(mView, 
				new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}
	
	public void dispose() {
		ViewGroup group = (ViewGroup) mView.getParent();
		group.removeView(mView);
		mView = null;
	}
	
	protected View getView() {
		return mView;
	}
	
	public View findViewById(int id) {
		return mView.findViewById(id);
	}
	
	public HSRect getBounds() {
		return new HSRect(mView.getLeft(), mView.getTop(), mView.getRight(), mView.getBottom());
	}
	
	public void setVisible(boolean visible) {
		mView.setVisibility(visible ? View.VISIBLE : View.GONE);
	}
	
	public boolean getVisible() {
		return mView.getVisibility() == View.VISIBLE;
	}
	
}