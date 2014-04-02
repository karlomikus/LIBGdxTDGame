package com.me.tdgame.enemies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.tdgame.logic.GameEntity;

public class Enemy extends GameEntity {
	
	private int health = 600;
	private boolean alive = true;
	
	public Enemy(float x, float y) {
		super(x, y);
		velocity.x = -50f;
		velocity.y = 0f;
		setSprite(new Sprite(new Texture("enemies/basic.gif")));
	}
	
	public void damage(float amount) {
		health -= amount;
		if(health <= 0) {
			System.out.println("Enemy DED!");
			alive = false;
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
}