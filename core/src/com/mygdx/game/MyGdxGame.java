package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MyGdxGame extends ApplicationAdapter {
    private OrthographicCamera cam;
    private SpriteBatch batch;
    private TiledMap tiledMap;
    private MyOrthogonalTiledMapRenderer tiledMapRenderer;
	
	@Override
	public void create () {
		batch = new SpriteBatch();

        tiledMap = new TmxMapLoader().load("map01.tmx");
        tiledMapRenderer = new MyOrthogonalTiledMapRenderer(tiledMap, 1/32f);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        cam = new OrthographicCamera(38, 38 * (h / w));
        cam.position.set(15, 15, 0);
        cam.update();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(cam.combined);

        if (Gdx.input.isKeyPressed(Input.Keys.UP)){ // up
            cam.translate(0, 0.1f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){ // down
            cam.translate(0, -0.1f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){ // left
            cam.translate(-0.1f, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){ // right
            cam.translate(0.1f, 0);
        }

        cam.update();

        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();


	}
}
