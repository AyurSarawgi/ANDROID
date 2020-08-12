package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] birds;
	int flapstate=0;
	float birdY;
	float gravity= (float) 0.8;
	float velocity=0;
	int gamestate=0;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background= new Texture("bg.png");
		birds=new Texture[2];
		birds[0]= new Texture("bird.png");
		birds[1]= new Texture("bird2.png");
		birdY=Gdx.graphics.getHeight()/2-birds[flapstate].getHeight()/2;
	}

	@Override
	public void render () {

		if(gamestate==1) {
			velocity = velocity + gravity;

			birdY -= velocity;
		}

		if(Gdx.input.justTouched()) {

			Gdx.app.log("Touched", "yep");
            velocity=-18;
			gamestate=1;

		}

		

		if (flapstate == 0)
		{
			flapstate=1;
		}else flapstate=0;

		batch.begin();
		batch.draw(background, 0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(birds[flapstate], Gdx.graphics.getWidth()/2-birds[flapstate].getWidth()/2, birdY);
		batch.end();



	}

}
