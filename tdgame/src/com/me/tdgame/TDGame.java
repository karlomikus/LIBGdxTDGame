package com.me.tdgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.tdgame.screens.playScreen;

public class TDGame extends Game {
	
	private SpriteBatch batch;
	public static final int TILE_SIZE = 32;
	
	@Override
	public void create() {		
		setScreen(new playScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
	
	public SpriteBatch getBatch() {
		return batch;
	}
}
