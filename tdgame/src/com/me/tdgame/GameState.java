package com.me.tdgame;

import com.badlogic.gdx.utils.Array;
import com.me.tdgame.enemies.Enemy;
import com.me.tdgame.projectiles.Projectile;
import com.me.tdgame.towers.Tower;

public class GameState {
	
	private Array<Enemy> enemies = new Array<Enemy>();
	private Array<Projectile> projectiles = new Array<Projectile>();
	private Array<Tower> towers = new Array<Tower>();
	
	public void addEnemy(Enemy e) {
		enemies.add(e);
	}
	
	public void addProjectile(Projectile p) {
		projectiles.add(p);
	}
	
	public void addTower(Tower t) {
		towers.add(t);
	}
	
	public Array<Enemy> getEnemies() {
		return enemies;
	}
	
	public Array<Projectile> getProjectiles() {
		return projectiles;
	}
	
	public Array<Tower> getTowers() {
		return towers;
	}
	
}
