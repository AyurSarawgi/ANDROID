package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, bottompipe[], toppipe[];
	Texture[] birds;
	int flapstate = 0;
	float birdY;
	float gravity = (float) 0.8;
	float velocity = 0;
	int gamestate = 0;
	int gap = 250;
	Random random;
	float tubeoffset;
	int velocitypipe = 0;

	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight() / 2 - birds[flapstate].getHeight() / 2;
		bottompipe = new Texture[2];
		bottompipe[0] = new Texture("bottomtube.png");
		bottompipe[1] = new Texture("bottomtube.png");
		toppipe = new Texture[2];
		toppipe[0] = new Texture("toptube.png");
		toppipe[1] = new Texture("toptube.png");

		random = new Random();
		tubeoffset = Gdx.graphics.getHeight() / 2 - toppipe[0].getHeight() / 2;
	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		if (gamestate == 1) {
			velocity = velocity + gravity;

			birdY -= velocity;
		}

		if (Gdx.input.justTouched()) {

			Gdx.app.log("Touched", "yep");
			velocity = -18;
			gamestate = 1;
			tubeoffset = (random.nextFloat() * 3.25f - 1f) * (Gdx.graphics.getHeight() / 2 - toppipe[0].getHeight() / 2);

		}

		if (birdY <= 0) {
			gamestate = 0;
		}

		if (flapstate == 0) {
			flapstate = 1;
		} else flapstate = 0;

		batch.draw(toppipe[0], Gdx.graphics.getWidth() / 2 - toppipe[0].getWidth() / 2 + velocitypipe, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset);
		batch.draw(bottompipe[0], Gdx.graphics.getWidth() / 2 - bottompipe[0].getWidth() / 2 + velocitypipe, -Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset);
		velocitypipe-=3;

			batch.draw(birds[flapstate], Gdx.graphics.getWidth() / 2 - birds[flapstate].getWidth() / 2, birdY);
			batch.end();
			
	}
}