package com.harigames.rain.entity.projectile;

import com.harigames.rain.graphics.Screen;
import com.harigames.rain.graphics.Sprite;

public class WizardProjectile extends Projectile {

	public static final int FIRE_RATE = 15;  //Higher is slower
	
	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 100;
		speed = 3	;
		damage = 20;
		sprite = Sprite.projectile_wizard;
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	@Override
	public void update() {
		move();
	}

	@Override
	public void render(Screen screen) {
		screen.renderProjectile((int) x - 12, (int) y - 2, this, 0);
	}

}
