package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Fixture;

import java.util.Random;




public class flappybird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background, bottompipe, toppipe,gameover,play,tapplay;
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
    int k=1;
	Circle birdcircle;
	Rectangle[] toppiperectangle;
	Rectangle[] bottompiperectangle;

	//ShapeRenderer shapeRenderer;


	@Override
	public void create() {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		birds = new Texture[2];
		birds[0] = new Texture("bird.png");
		birds[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight() / 2 - birds[flapstate].getHeight() / 2;
        gameover=new Texture("gameover.png");
		play=new Texture("playbutton.png");
		tapplay=new Texture("tapplay.png");
        bottompipe = new Texture("bottomtube.png");


		toppipe = new Texture("toptube.png");

		distbtwpipes=Gdx.graphics.getWidth()/2;

		toppiperectangle=new Rectangle[numberofpipes];
		bottompiperectangle=new Rectangle[numberofpipes];
        startgame();

	birdcircle=new Circle();

	//shapeRenderer=new ShapeRenderer();


	}

	public void startgame()
	{
		for(int i=0;i<numberofpipes-1;i++)
		{


			tubeX[i]=Gdx.graphics.getWidth()+200  - toppipe.getWidth() / 2  +i*distbtwpipes*1.2f ;
			random = new Random();

			tubeoffset[i] = (float) ( Math.random() * (max - min + 1) + min) * (Gdx.graphics.getHeight()/2 - toppipe.getHeight()/2 );

			toppiperectangle[i]=new Rectangle();
			bottompiperectangle[i]=new Rectangle();
		}
	}

	@Override
	public void render() {
		batch.begin();

		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if(k==1)
		{batch.draw(tapplay, Gdx.graphics.getWidth()/2-150/2, Gdx.graphics.getHeight()/2-400,150,150);}
		if (gamestate == 1) {

			velocity = velocity + gravity;

			birdY -= velocity;
		}

		if (Gdx.input.justTouched()) {
			k=0;
			Gdx.app.log("Touched", "yep");
			velocity = -20;
			gamestate = 1;


		}




		if (birdY <= 0 ) {

		}

		if (flapstate == 0) {
			flapstate = 1;
		} else flapstate = 0;

		//shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		//shapeRenderer.setColor(Color.RED);


		batch.draw(birds[flapstate], Gdx.graphics.getWidth() / 2 - birds[flapstate].getWidth() / 2, birdY);
		birdcircle.set(Gdx.graphics.getWidth() / 2 , birdY + birds[flapstate].getHeight()/2,(birds[flapstate].getWidth()/2)-10);
		//shapeRenderer.circle(birdcircle.x,birdcircle.y,birdcircle.radius);


	for (int i = 0; i < numberofpipes - 1; i++) {
		if(gamestate==1) {
			if (tubeX[i] < -toppipe.getWidth()) {
				tubeoffset[i] = (float) (Math.random() * (max - min + 1) + min) * (Gdx.graphics.getHeight() / 2 - toppipe.getHeight() / 2);

				tubeX[i] = tubeX[i] + numberofpipes * distbtwpipes - toppipe.getWidth();
			} else {
				tubeX[i] -= velocitypipe;
			}

			batch.draw(toppipe, tubeX[i] + 20, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i] + 100);
			batch.draw(bottompipe, tubeX[i] + 20, -Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i] + 200);

			toppiperectangle[i].set(tubeX[i] + 20, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i] + 100, toppipe.getWidth(), toppipe.getHeight());
			//shapeRenderer.rect(tubeX[i] +20, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i]+100,toppipe.getWidth(),toppipe.getHeight());

			bottompiperectangle[i].set(tubeX[i] + 20, -Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i] + 200, bottompipe.getWidth(), bottompipe.getHeight());
			//shapeRenderer.rect(tubeX[i] +20, -Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i]+200,bottompipe.getWidth(),bottompipe.getHeight());
		}
		if (Intersector.overlaps(birdcircle, bottompiperectangle[i]) || Intersector.overlaps(birdcircle, toppiperectangle[i])) {
			Gdx.app.log("colloide", "yes");
			batch.draw(toppipe, tubeX[i] + 20, Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i] + 100);
			batch.draw(bottompipe, tubeX[i] + 20, -Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i] + 200);

			batch.draw(gameover, Gdx.graphics.getWidth() / 2 - gameover.getWidth() / 2, Gdx.graphics.getHeight() / 2 - gameover.getHeight() / 2);

			batch.draw(play, Gdx.graphics.getWidth() / 2 - 150 / 2, Gdx.graphics.getHeight() / 2 - gameover.getHeight() + 50, 150, 150);

			gamestate = 0;

			velocitypipe = 0;


			if(Gdx.input.justTouched())
			{
				startgame();
				gamestate = 1;
				velocitypipe = 5;
			}

		}


}
			batch.end();
		//shapeRenderer.end();
	}
}