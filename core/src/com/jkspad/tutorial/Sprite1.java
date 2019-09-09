package com.jkspad.tutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * @author John Knight
 * Copyright http://www.jkspad.com
 *
 */
public class Sprite1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private TextureRegion region;

	private OrthographicCamera camera;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		region = new TextureRegion(img);
		region.flip(false, true);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(region, 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		camera = new OrthographicCamera(width, height);
		camera.setToOrtho(true, width, height);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		img.dispose();
	}
}
