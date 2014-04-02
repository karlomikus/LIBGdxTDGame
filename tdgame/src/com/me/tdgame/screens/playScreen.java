package com.me.tdgame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.me.tdgame.GameState;
import com.me.tdgame.TDGame;
import com.me.tdgame.enemies.Enemy;
import com.me.tdgame.logic.InputHandler;
import com.me.tdgame.projectiles.Projectile;
import com.me.tdgame.towers.Tower;

public class playScreen implements Screen {
	
	public float w, h;
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private GameState gameState;
	
	public Texture projectileTex;
	public Texture enemyTex;
		
	public playScreen(TDGame game) {
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		// Get spritebatch reference from main class
		batch = game.getBatch();
		
		projectileTex = new Texture("projectiles/arrow.gif");
		enemyTex = new Texture("enemies/basic.gif");
		gameState = new GameState();
		
		// Set processors
		Gdx.input.setInputProcessor(new InputHandler());
	}
	
	@Override
	public void show() {
		// Load map and renderers
		map = new TmxMapLoader().load("maps/map.tmx");
		renderer = new OrthogonalTiledMapRenderer(map);
		batch = (SpriteBatch) renderer.getSpriteBatch();
		
		// Camera
		camera = new OrthographicCamera();
		camera.position.set(w/2, h/2, 0);
		
		gameState.addEnemy(new Enemy(w/2, h/2));
		gameState.addEnemy(new Enemy(w/2 + 32, h/2));
		
		gameState.addTower(new Tower(120, 256, gameState));
		gameState.addTower(new Tower(152, 256, gameState));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.setView(camera);
		renderer.render();
		
		// Update projectiles
		for(Projectile p : gameState.getProjectiles()) {
			p.update(delta);
		}
		
		// Update towers
		for(Tower t : gameState.getTowers()) {
			t.update(delta);
		}
		
		// Renderer
		batch.begin();
		
		// Render enemies
		for(Enemy e : gameState.getEnemies()) {
			e.getSprite().draw(batch);
			e.update(delta);
			checkEnemyHit(e);
		}
		
		// Render towers
		for(Tower t : gameState.getTowers()) {
			t.getSprite().draw(batch);
		}
		
		// Render projectiles
		for(Projectile p : gameState.getProjectiles()) {
			p.getSprite().draw(batch);
		}
		
		batch.end();
	}
	
	public void checkEnemyHit(Enemy e) {
		for(Projectile p : gameState.getProjectiles()) {
			if(p.getCollisionBounds().overlaps(e.getCollisionBounds())) {
				gameState.getProjectiles().removeValue(p, true);
				e.damage(p.getDamage());
				if(!e.isAlive())
					gameState.getEnemies().removeValue(e, true);
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
	}
	
	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		batch.dispose();
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
