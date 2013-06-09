package com.harigames.rain.level.tile;

import com.harigames.rain.graphics.Screen;
import com.harigames.rain.graphics.Sprite;
import com.harigames.rain.level.tile.spawn_level.SpawnFloorTile;
import com.harigames.rain.level.tile.spawn_level.SpawnGrassTile;
import com.harigames.rain.level.tile.spawn_level.SpawnHedgeTile;
import com.harigames.rain.level.tile.spawn_level.SpawnSandTile;
import com.harigames.rain.level.tile.spawn_level.SpawnWallTile;
import com.harigames.rain.level.tile.spawn_level.SpawnWaterTile;

public class Tile {
	
	public int x, y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	public static Tile spawn_sand = new SpawnSandTile(Sprite.spawn_sand);
	
	public static final int col_spawn_grass = 0xff00ff00;
	public static final int col_spawn_hedge = 0; //unused
	public static final int col_spawn_wall1 = 0xff404040;
	public static final int col_spawn_wall2 = 0xff202020;
	public static final int col_spawn_floor = 0xff8b4513;
	public static final int col_spawn_sand  = 0xffffe97f;
	public static final int col_spawn_water = 0xff6dffda;
	public static final int col_spawn_point = 0xff00ffff;
	
	public Tile (Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public boolean isBreakable() {
		return false;
	}

}
