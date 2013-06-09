package com.harigames.rain.level.tile.spawn_level;

import com.harigames.rain.graphics.Sprite;
import com.harigames.rain.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
