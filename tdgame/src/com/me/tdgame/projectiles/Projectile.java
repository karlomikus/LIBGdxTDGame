package com.me.tdgame.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.me.tdgame.enemies.Enemy;
import com.me.tdgame.logic.GameEntity;

public class Projectile extends GameEntity {
	
	private Enemy target;
	private Vector2 direction;
	
	private final float DAMAGE = 100;
	private final float SPEED = 50;
	
	public Projectile(float x, float y) {
		super(x, y);
		this.direction = new Vector2();
		collisionBounds.width = 5;
		collisionBounds.height = 10;
		setSprite(new Sprite(new Texture("projectiles/arrow.gif")));
	}
	
	@Override
	public void update(float delta) {
		direction.set(target.getPosition());
		direction.sub(position);
		direction.nor();
		
		direction.scl(SPEED * delta);
		position.add(direction);
		
		sprite.setPosition(position.x, position.y);
		
		collisionBounds.x = position.x;
		collisionBounds.y = position.y;
	}
	
	public void setTarget(Enemy target) {
		this.target = target;
	}
	
	public Enemy getTarget() {
		return target;
	}
	
	public float getDamage() {
		return DAMAGE;
	}

}