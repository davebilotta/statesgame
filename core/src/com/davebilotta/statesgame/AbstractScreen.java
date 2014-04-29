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
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class AbstractScreen implements Screen {

	Stage stage;
	int w, h;
	String[] buttons;

	int buttonW, buttonH, buttonSpacer;
	int startY, xPos, yPos;
	TextButtonStyle style;
	LabelStyle labelStyle;

	StatesGame game;
	String topText;
	boolean correct = false;
	boolean transitionOut = false;
	float transitionSpeed = 0.75f;

	public AbstractScreen(StatesGame game) {
		this.game = game;

		this.style = new TextButtonStyle();
		this.labelStyle = new LabelStyle();
		
		style.font = StatesGame.font;
		Color color = new Color(255,0,0, transitionSpeed);
		style.fontColor = Color.ORANGE;
		
		labelStyle.font = StatesGame.font;
		labelStyle.fontColor = Color.WHITE;

		buttonW = 100;
		buttonH = 50;
		buttonSpacer = 25;

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
		buildImage();
		buildButtons();

	}

	// Background
	public void buildBackground() {
		Image bkg = new Image(StatesGame.bkg);
		bkg.setName("background");
		stage.addActor(bkg);
	}

	public void buildTopText() {
		Label topText = new Label(this.topText, labelStyle);
		// TODO: Fix this
		int textHeight = 40;
		int leftOffset = 10;

		//topText.setPosition(leftOffset, (h - textHeight));
		//topText.setPosition(300,(h-textHeight));
		topText.setBounds(leftOffset, (h - textHeight), w, textHeight);
		topText.setAlignment(1);
		
		topText.setWrap(true);

		topText.setName("topText");
		stage.addActor(topText);
	}

	// Builds image on left side of screen
	public void buildImage() {
		Image image = new Image(new Texture("Blank_US_Map.png"));
		image.setName("leftimage");
		image.setPosition(0, (h - 317) / 2);
		// 512w x 317h
		stage.addActor(image);
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

	public void transitionOut(final LevelScreen screen) {
		
		Array<Actor> actors = stage.getActors();
		Actor a;
		
		
		final int s = actors.size - 1;
		if (!transitionOut) {
			for (int i = 0; i < actors.size; i++) {
				a = actors.get(i);
				final int j = i;
		
				// These shouldn't be here, only b/c we need a's x and Y position
				Action fadeOut = Actions.fadeOut(.5f);
				Action slideLeft = Actions.moveTo((0 - 2000), a.getY(),transitionSpeed);
				Action slideDown = Actions.moveTo(a.getX(),(0-1000),transitionSpeed);
						
				// Don't transition background
				if(a.getName() != "background") {
					//a.addAction(Actions.sequence(Actions.moveTo(0 - 2000, a.getY(), transitionSpeed), Actions.run(new Runnable() {
					a.addAction(Actions.sequence(slideDown, Actions.run(new Runnable() {
						
					    public void run () {
					    	if (j == s) {
					    		System.out.println( "Action complete!");
					    		if (screen != null) {
					    			game.setScreen(screen);
					    		}
					    		else {
					    			//game.setScreen(screen);
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
