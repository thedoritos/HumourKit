package com.humooooour.kit.geom;

import android.graphics.PointF;

public class HSPoint extends PointF {
	
	public HSPoint() {
		super();
	}
	
	public HSPoint(float x, float y) {
		super(x, y);
	}
	
	public HSPoint(HSPoint pt) {
		super(pt.x, pt.y);
	}
	
	public void add(HSPoint point) {
		x += point.x;
		y += point.y;
	}
	
	public void sub(HSPoint point) {
		x -= point.x;
		y -= point.y;
	}
	
	public void scl(float scaler) {
		x *= scaler;
		y *= scaler;
	}
	
	public float dist(HSPoint point) {
		return (float) Math.sqrt(distSq(point));
	}
	
	public float distSq(HSPoint pt) {
		return (float) (Math.pow(pt.x - this.x, 2) + Math.pow(pt.y - this.y, 2));
	}
	
	public float dist(HSPoint segStart, HSPoint segEnd) {
		double angleSeg = Math.atan2(segEnd.y - segStart.y, segEnd.x - segStart.x);
		double anglePt  = Math.atan2(  this.y - segStart.y,   this.x - segStart.x);
		return dist(segStart) * (float) Math.abs(Math.sin(angleSeg - anglePt));
	}
	
	public boolean isBetween(HSPoint pt1, HSPoint pt2) {
		return isBetween(pt1, pt2, 0.0f);
	}
	
	public boolean isBetween(HSPoint pt1, HSPoint pt2, float permissible) {
		return ((pt1.x - this.x) * (pt2.x - this.x) < permissible * permissible)
			&& ((pt1.y - this.y) * (pt2.y - this.y) < permissible * permissible);
	}
	
	public void setBetween(HSPoint posFrom, HSPoint posTo, float rate) {
		set(posFrom.x + (posTo.x - posFrom.x) * rate, posFrom.y + (posTo.y - posFrom.y) * rate);
	}
}
