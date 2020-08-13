package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Fixture;

import java.util.Random;

public class flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, bottompipe, toppipe;
	Texture[] birds;
	int flapstate = 0;
	float birdY;
	float gravity = (float) 0.8;
	float velocity = 0;
	int gamestate = 0;
	int gap = 100;
	Random random;
	int numberofpipes=4;
	float[] tubeoffset=new float[numberofpipes];
	int velocitypipe = 5;
	float[] tubeX=new float[numberofpipes];
float distbtwpipes;
float max= (float) 0.99;
	float min= (float) -0.99;


	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight() / 2 - birds[flapstate].getHeight() / 2;

		bottompipe = new Texture("bottomtube.png");


		toppipe = new Texture("toptube.png");

		distbtwpipes=Gdx.graphics.getWidth()/2;


		for(int i=0;i<numberofpipes-1;i++)
		{


		tubeX[i]=Gdx.graphics.getWidth() / 2 - toppipe.getWidth() / 2 +i*distbtwpipes*1.2f ;
		random = new Random();

			tubeoffset[i] = (float) ( Math.random() * (max - min + 1) + min) * (Gdx.graphics.getHeight()/2 - toppipe.getHeight()/2 );


	}}

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
			velocity = -20;
			gamestate = 1;


		}




		if (birdY <= 0 ) {
			gamestate = 0;
			velocitypipe=0;
		}

		if (flapstate == 0) {
			flapstate = 1;
		} else flapstate = 0;


		for(int i=0;i<numberofpipes-1;i++) {

			if(tubeX[i] < -toppipe.getWidth())
			{tubeoffset[i] = (float) ( Math.random() * (max - min + 1) + min) * (Gdx.graphics.getHeight()/2 - toppipe.getHeight()/2 );

				tubeX[i]= tubeX[i]+ numberofpipes*distbtwpipes - toppipe.getWidth();
			}else {tubeX[i]-=velocitypipe;}

			batch.draw(toppipe, tubeX[i] +20, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i]+100);
			batch.draw(bottompipe, tubeX[i] +20, -Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i]+200);

			

		}

			batch.draw(birds[flapstate], Gdx.graphics.getWidth() / 2 - birds[flapstate].getWidth() / 2, birdY);
			batch.end();

	}
}