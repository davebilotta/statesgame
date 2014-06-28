package com.davebilotta.statesgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class AbstractScreen implements Screen {

	Stage stage;
	int w, h;
	String[] buttons;
	String leftImagePath;
	
	int buttonW, buttonH, buttonSpacer;
	int startY, xPos, yPos;
	TextButtonStyle style;
	LabelStyle labelStyle,labelStyle2;

	StatesGame game;
	String topText, topText2;
	boolean correct = false;
	boolean transitionOut = false;
	float transitionSpeed = 1.5f;

	public AbstractScreen(StatesGame game) {
		this.game = game;

		this.style = new TextButtonStyle();
		this.labelStyle = new LabelStyle();
		this.labelStyle2 = new LabelStyle();
		
		style.font = StatesGame.font;
		Color color = new Color(255,0,0, transitionSpeed);
		style.fontColor = Color.ORANGE;
		
		labelStyle.font = StatesGame.font;
		labelStyle2.font = StatesGame.font2;
		labelStyle.fontColor = Color.WHITE;
		labelStyle2.fontColor = Color.RED;
		
		buttonW = 100;
		buttonH = 50;
		buttonSpacer = 25;
		
		//if (game.)

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		transitionOut = false;
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		stage = new Stage(new ScreenViewport());
		stage.getViewport().update(w, h, true);
		stage.clear();
		Gdx.input.setInputProcessor(stage);

		buildBackground();
		buildTopText();
		buildMenuButtons();
		
		buildImage();
		buildButtons();

	}

	// Background
	public void buildBackground() {
		Image bkg = new Image(StatesGame.bkg);
		bkg.setName("background");
		stage.addActor(bkg);
	}

	public void buildMenuButtons() {
		
	}
	
	public void buildTopText() {
		Label topText = new Label(this.topText, labelStyle);
		// TODO: Fix this
		int textHeight = 80;
		int leftOffset = 10;

		//topText.setPosition(leftOffset, (h - textHeight));
		//topText.setPosition(300,(h-textHeight));
		topText.setBounds(leftOffset, (h - textHeight), w, textHeight);
		topText.setAlignment(1);
		topText.setWrap(true);
		topText.setName("topText");
		stage.addActor(topText);
		
		if (this.topText2 != null) {
			Label topText2 = new Label(this.topText2, labelStyle2);

			topText2.setBounds(leftOffset, (h - (int)(textHeight * 1.5)), w, textHeight);
			topText2.setAlignment(1);
			topText2.setWrap(true);
			topText2.setName("topText2");
			stage.addActor(topText2);
		}
	}

	// Builds image on left side of screen
	public void buildImage() {

		
		float scaleX,scaleY;
		
		String path = this.leftImagePath;
		
		// Workaround for not all states having images
		if (!path.equals("")) {
			// TODO: fix heights
			Texture text = new Texture(path);
			
			Image image = new Image(new Texture(path));
			image.setName("leftimage");	
			
			// TODO: Fix scaling for really big images like California
			if ((image.getWidth() > 400) || (image.getHeight() > 400)) {
				scaleX = scaleY = 0.5f;
			}
			else {
				scaleX = scaleY = 1.0f;
			}
		
			image.setPosition(25, ((h - image.getHeight() * scaleY) / 2));
			image.setScale(scaleX,scaleY);
			
			image.setColor(new Color(0,148,189,0.5f));
			
		 
			//Drawable draw = new Drawable(image);
			//draw.image = image;
			//Image img = new Image (
					
			stage.addActor(image);
		}
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void render(float delta) {
		stage.act();
		stage.draw();
	}

	//public void transitionOut(final LevelScreen screen) {
	public void transitionOut(final AbstractScreen screen) {
		
		Array<Actor> actors = stage.getActors();
		Actor a;
		
		
		final int s = actors.size - 1;
		if (!transitionOut) {
			for (int i = 0; i < actors.size; i++) {
				a = actors.get(i);
				final int j = i;
		
				// These shouldn't be here, only b/c we need a's x and Y position
				Action fadeOut = Actions.fadeOut(transitionSpeed);
				Action slideLeft = Actions.moveTo((0 - 2000), a.getY(),transitionSpeed);
				Action slideDown = Actions.moveTo(a.getX(),(0-1000),transitionSpeed);
						
				// Don't transition background or Home button
				
				if(a.getName() == "background" || a.getName() == "home") {
					
				}
				else {
					Action transitionEffect = fadeOut;
					a.addAction(Actions.sequence(transitionEffect, Actions.run(new Runnable() {
						
					    public void run () {
					    	if (j == s) {
					    		//System.out.println( "Action complete!");
					    		if (screen != null) {
					    			game.setScreen(screen);
					    		}
					    		
					    	}
					    }
					}))); // end of addAction
			}
		} // end for
		}// end if
	}

	@Override
	public void hide() {

	}

	public void buildButtons() {
	}

}
