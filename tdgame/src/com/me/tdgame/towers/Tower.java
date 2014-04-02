package com.me.tdgame.towers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.tdgame.GameState;
import com.me.tdgame.enemies.Enemy;
import com.me.tdgame.logic.GameEntity;
import com.me.tdgame.projectiles.Projectile;

public class Tower extends GameEntity {
	
	private final float FIRE_RATE = 0.5f; // In seconds
	private final int range = 150;
	private float fireTimer = 1000f;
	
	private GameState gameState;
	
	public Tower(int x, int y, GameState gameState) {
		super(x, y);
		this.gameState = gameState;
		setSprite(new Sprite(new Texture("towers/basic.png")));
	}
	
	@Override
	public void update(float delta) {
		super.update(delta);
		fireProjectile(delta);
	}
	
	private Enemy findTarget() {
		float distance = 0;
		Enemy target = null;
		for(Enemy e : gameState.getEnemies()) {
			distance = e.getPosition().dst(position);
			if(distance <= range) {
				target = e;
			}
		}
		return target;
	}
	
	private void fireProjectile(float delta) {
		Enemy e = findTarget();
		if(e != null) {
			fireTimer += delta;
			if(fireTimer >= FIRE_RATE) {
				Projectile p = new Projectile(position.x + 16, position.y + 16);
				p.setTarget(e);
				gameState.addProjectile(p);
				fireTimer = 0;
			}
		}
	}

}