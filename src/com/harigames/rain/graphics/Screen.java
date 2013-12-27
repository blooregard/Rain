package com.harigames.rain.graphics;

import java.awt.Color;
import java.util.Random;

import com.harigames.rain.entity.projectile.Projectile;
import com.harigames.rain.level.tile.Tile;

public class Screen {

	public static final int DARKNESS = 75;

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];

		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0
						|| ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = darken(tile.sprite.pixels[x + y
						* tile.sprite.SIZE]);
			}
		}
	}

	public void renderProjectile(int xp, int yp, Projectile p, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < p.getSpriteSize(); y++) {
			int ya = y + yp;
			for (int x = 0; x < p.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -p.getSpriteSize() || xa >= width || ya < 0
						|| ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
				if (col != 0xffff00ff)
					pixels[xa + ya * width] = darken(col);
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite sprite, int flip) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			int ys = y;
			if (flip == 2 || flip == 3) {
				ys = sprite.SIZE - 1 - y;
			}
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				int xs = x;

				if (flip == 1 || flip == 3) {
					xs = sprite.SIZE - 1 - x;
				}
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int col = sprite.pixels[xs + ys * sprite.SIZE];
				if (col != 0xffff00ff)
					pixels[xa + ya * width] = darken(col);
			}
		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	private int darken(int pixel) {
		Color c = new Color(pixel);
		int red = (c.getRed() - DARKNESS) <= 0 ? 0 : c.getRed() - DARKNESS;
		int green = (c.getGreen() - DARKNESS) <= 0 ? 0 : c.getGreen()
				- DARKNESS;
		int blue = (c.getBlue() - DARKNESS) <= 0 ? 0 : c.getBlue() - DARKNESS;
		c = new Color(red, green, blue);
		return c.getRGB();
	}

}
