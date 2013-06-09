package com.harigames.rain.level.tile.spawn_level;

import com.harigames.rain.graphics.Sprite;
import com.harigames.rain.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}
	
	@Override
	public boolean isBreakable() {
		return true;
	}

}
