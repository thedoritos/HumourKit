package com.humooooour.kit.graphics;

import com.humooooour.kit.geom.HSPoint;
import com.humooooour.kit.geom.HSRect;

import processing.core.PGraphics;

public class HSGraphics {
	
	public static final void drawBackground(PGraphics g, HSRect bounds, int hexColor) {
		g.noStroke();
		g.fill(hexColor);
		g.rectMode(PGraphics.CORNER);
		g.rect(bounds.left, bounds.top, bounds.width(), bounds.height());
	}
	
	public static final void drawRect(PGraphics g, HSRect bounds) {
		g.rectMode(PGraphics.CORNER);
		g.rect(bounds.left, bounds.top, bounds.width(), bounds.height());
	}
	
	public static final void drawCircle(PGraphics g, HSPoint center, float radius) {
		g.ellipseMode(PGraphics.CENTER);
		g.ellipse(center.x, center.y, radius * 2.0f, radius * 2.0f);
	}
	
}
