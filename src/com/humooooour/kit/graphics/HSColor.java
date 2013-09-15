package com.humooooour.kit.graphics;

public class HSColor {
	
	public static final int getRandomColor(int alpha) {
		int red = (int) (Math.random() * 0xFF);
		int grn = (int) (Math.random() * 0xFF);
		int blu = (int) (Math.random() * 0xFF);
		return (alpha << 24) | (red << 16) | (grn << 8) | blu;
	}
	
	public static final int getColor(int baseColor, int alpha) {
		int rgb = 0x00FFFFFF & baseColor;
		return (alpha << 24) | rgb;
	}
	
}
