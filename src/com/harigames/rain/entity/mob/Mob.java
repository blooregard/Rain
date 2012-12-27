package com.harigames.rain.entity.mob;

import com.harigames.rain.entity.Entity;
import com.harigames.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	
	public void move(int xa, int ya) {
		if (xa > 0) dir = 1; // East
		if (xa < 0) dir = 3; // West
		if (ya > 0) dir = 2; // South
		if (ya < 0) dir = 0; // North
		
		if (!collision()) {
			x += xa;
			y += ya;
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		
	}
	
	private boolean collision() {
		return false;
	}
}
