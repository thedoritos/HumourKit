package com.humooooour.kit.geom;

import android.graphics.RectF;


public class HSRect extends RectF {
	
	public HSRect() {
		super();
	}
	
	public HSRect(float left, float top, float right, float bottom) {
		super(left, top, right, bottom);
	}
	
	public HSRect(HSRect source) {
		super(source);
	}
	
	public void scale(float sx, float sy) {
		right = left + width() * sx;
		bottom = top + height() * sy;
	}
	
	public void setWidth(float width) {
		right = left + width;
	}
	
	public void setHeight(float height) {
		bottom = top + height;
	}
	
	public boolean contains(HSPoint pos) {
		return super.contains(pos.x, pos.y);
	}
	
	public HSPoint getCenter() {
		return new HSPoint(centerX(), centerY());
	}
	
	public HSPoint getAbsPos(HSPoint norPos) {
		return new HSPoint(getAbsX(norPos.x), getAbsY(norPos.y));
	}
	
	public HSPoint getNorPos(HSPoint absPos) {
		return new HSPoint(getNorX(absPos.x), getNorY(absPos.y));
	}
	
	public float getAbsX(float rate) {
		return left + width() * rate;
	}
	
	public float getAbsY(float rate) {
		return top + height() * rate;
	}
	
	public float getNorX(float x) {
		return (x - this.top) / width();
	}
	
	public float getNorY(float y) {
		return (y - this.left) / height();
	}
	
}
