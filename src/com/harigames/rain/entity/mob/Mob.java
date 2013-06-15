package com.harigames.rain.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.harigames.rain.entity.Entity;
import com.harigames.rain.entity.projectile.Projectile;
import com.harigames.rain.entity.projectile.WizardProjectile;
import com.harigames.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected boolean walking = false;

	public void move(int xa, int ya) {
		
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0)
			dir = 1; // East
		if (xa < 0)
			dir = 3; // West
		if (ya > 0)
			dir = 2; // South
		if (ya < 0)
			dir = 0; // North

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {
	}
	
	protected void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i ++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) {
				level.getProjectiles().remove(i);
				p = null;
			}
		}
		
	}

	protected void shoot(int x, int y, double dir) {
		Projectile p = new WizardProjectile(x, y, dir);
		level.addProjectile(p);
	}

	public void render() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 12 - 7) >> 4;
			int yt = ((y + ya) + c / 2 * 12 + 3) >> 4;
			if (level.getTile(xt, yt).isSolid()) {
				solid = true;
			}

		}
		return solid;
	}
}
