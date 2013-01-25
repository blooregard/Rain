package com.harigames.rain.entity.mob;

import com.harigames.rain.graphics.Screen;
import com.harigames.rain.graphics.Sprite;
import com.harigames.rain.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int animation = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_down;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_down;
	}

	public void update() {
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
