package com.me.tdgame.logic;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameEntity {
	
	protected Vector2 position;
	protected Vector2 velocity;
	protected Rectangle collisionBounds;
	protected Sprite sprite;
	
	public GameEntity(float x, float y) {
		this.position = new Vector2(x, y);
		this.velocity = new Vector2();
		this.collisionBounds = new Rectangle(x, y, 32, 32);
	}
	
	public void update(float delta) {
		if(delta == 0) return;
		
		position.x += velocity.x * delta;
		position.y += velocity.y * delta;
		
		sprite.setPosition(position.x, position.y);
		
		collisionBounds.x = position.x;
		collisionBounds.y = position.y;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Vector2 getVelocity() {
		return velocity;
	}
	
	public Rectangle getCollisionBounds() {
		return collisionBounds;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}
	
	public void setCollisionBounds(Rectangle collisionBounds) {
		this.collisionBounds = collisionBounds;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}