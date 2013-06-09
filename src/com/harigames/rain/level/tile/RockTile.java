package com.harigames.rain.level.tile;

import com.harigames.rain.graphics.Sprite;

public class RockTile extends Tile {

	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public boolean solid() {
		return true;
	}

}
