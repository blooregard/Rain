package com.harigames.rain.entity.projectile;

import com.harigames.rain.entity.Entity;
import com.harigames.rain.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final double xOrigin, yOrigin;
	protected double angle;
	public Sprite sprite;
	protected double x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage;

	public Projectile(int x, int y, double dir) {
		this.xOrigin = x;
		this.yOrigin = y;
		this.angle = dir;
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	public int getSpriteSize() {
		return this.sprite.SIZE;
	}

	protected void move() {
		x += nx;
		y += ny;

		if (distance() > range) remove();
	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x) * (xOrigin - x))
				+ Math.abs((yOrigin - y) * (yOrigin - y)));
		return dist;
	}
}
