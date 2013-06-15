package com.harigames.rain.entity.mob;

import com.harigames.rain.Game;
import com.harigames.rain.entity.projectile.Projectile;
import com.harigames.rain.entity.projectile.WizardProjectile;
import com.harigames.rain.graphics.Screen;
import com.harigames.rain.graphics.Sprite;
import com.harigames.rain.input.Keyboard;
import com.harigames.rain.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int animation = 0;
	private boolean walking = false;
	private int fireRate;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_down;
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_down;
	}

	public void update() {
		if (fireRate > 0) fireRate--;
		int xa = 0, ya = 0;
		animation += 1 % 30;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		clear();
		updateShooting();
	}

	private void updateShooting() {
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
		
		
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0) {
			if (walking) {
				if (animation % 30 < 10) {
					sprite = Sprite.player_up;
				} else if (animation % 30 < 20) {
					sprite = Sprite.player_up_1;
				} else {
					sprite = Sprite.player_up_2;
				}
			}
		}
		if (dir == 2) {
			if (walking) {
				if (animation % 30 < 10) {
					sprite = Sprite.player_down;
				} else if (animation % 30 < 20) {
					sprite = Sprite.player_down_1;
				} else {
					sprite = Sprite.player_down_2;
				}
			}
		}
		if (dir == 1) {
			if (walking) {
				if (animation % 30 < 10) {
					sprite = Sprite.player_side;
				} else if (animation % 30 < 20) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		if (dir == 3) {
			flip = 1;
			if (walking) {
				if (animation % 30 < 10) {
					sprite = Sprite.player_side;
				} else if (animation % 30 < 20) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}
}
