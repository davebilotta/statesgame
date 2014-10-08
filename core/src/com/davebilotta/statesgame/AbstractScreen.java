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
import com.davebilotta.statesgame.StatesGame.ScreenType;

public class AbstractScreen implements Screen {

	Stage stage;
	int w, h;
	String[] buttons;
	String leftImagePath;

	int buttonW, buttonH, buttonSpacer;
	int startY, xPos, yPos;
	TextButtonStyle style, selectedStyle;
	LabelStyle labelStyle, labelStyle2;

	StatesGame game;
	String topText, topText2;
	boolean correct = false;
	boolean transitionOut = false;
	float transitionSpeed = 1.0f;
	
	ScreenType screenType;
	
	public AbstractScreen(StatesGame game) {
		this.game = game;

		this.style = new TextButtonStyle();
		style.font = StatesGame.font;
		style.fontColor = Color.ORANGE;

		this.selectedStyle = new TextButtonStyle();
		selectedStyle.font = StatesGame.font;
		selectedStyle.fontColor = Color.GRAY;

		this.labelStyle = new LabelStyle();
		labelStyle.font = StatesGame.font;
		labelStyle.fontColor = Color.WHITE;
		
		this.labelStyle2 = new LabelStyle();
		labelStyle2.font = StatesGame.font;
		labelStyle2.fontColor = Color.LIGHT_GRAY;

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
		
		int textHeight;
		
		if (this.game.n7) textHeight = 120;
		else textHeight = 80;
		int leftOffset = 10;

		topText.setBounds(leftOffset, (h - textHeight), w, textHeight);
		topText.setAlignment(1);
		topText.setWrap(true);
		topText.setName("topText");
		stage.addActor(topText);

		if (this.topText2 != null) {
			Label topText2 = new Label(this.topText2, labelStyle2);

			topText2.setBounds(leftOffset, (h - (int) (textHeight * 1.5)), w,
					textHeight);
			topText2.setAlignment(1);
			topText2.setWrap(true);
			topText2.setName("topText2");
			stage.addActor(topText2);
		}
	}

	// Builds image on left side of screen
	public void buildImage() {

		float scaleX, scaleY = 1.0f;

		String path = this.leftImagePath;

		// Workaround for not all states having images
		if (!path.equals("")) {
			
			Texture text = new Texture(path);

			Image image = new Image(new Texture(path));
			scaleX = scaleY = getScaling(image);

			//image.setPosition(((w-40)- (image.getHeight() * scaleY))/2, ((h - image.getHeight() * scaleY) / 2));
			int pos;
			if (this.screenType == ScreenType.MAIN) pos = 25;
			else pos = 100;
			image.setPosition(pos, ((h - image.getHeight() * scaleY) / 2));
			image.setScale(scaleX, scaleY);

			stage.addActor(image);
		}

	}

	public float getScaling(Image image) {
		// TODO: Fix scaling for really big images like California

		float scale;
		
		if (this.screenType == ScreenType.MAIN) {
			scale = 1.0f;
			return scale;
		} 
		if ((image.getWidth() > 1200) || (image.getHeight() > 1200)) {
			scale = 0.25f;
			return scale;
		}
		else {
			if ((image.getWidth() > 1000) || (image.getHeight() > 1000)) {
				scale = 0.33f;
				return scale;
			}
			if ((image.getWidth() > 900) || (image.getHeight() > 900)) {
				scale = 0.40f;
				return scale;
			} 
			if ((image.getWidth() > 600) || (image.getHeight() > 600)) {
				scale = 0.5f;
				return scale;
			}
			if ((image.getWidth() > 400) || (image.getHeight() > 400)) {
					scale = 0.75f;
					return scale;
			}
			else {
				scale = 1.0f;
				return scale;
				}
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
	
	
	public void transitionOut(final AbstractScreen screen) {
		
			Array<Actor> actors = this.stage.getActors();
			Actor a;
			
			final int s = actors.size - 1;
			
			if (!transitionOut) {
				for (int i = 0; i < actors.size; i++) {
					a = actors.get(i);
					final int j = i;

					// These shouldn't be here, only b/c we need a's x and Y
					// position
					Action fadeOut = Actions.fadeOut(transitionSpeed);
					Action slideLeft = Actions.moveTo((0 - 2000), a.getY(),
							transitionSpeed);
					Action slideDown = Actions.moveTo(a.getX(), (0 - 1000),
							transitionSpeed);

					// Don't transition background, Home, or Top Text
					if (a.getName() == "background" || a.getName() == "home" || a.getName() == "topText") {

					} else {
						Action transitionEffect = fadeOut;
						a.addAction(Actions.sequence(transitionEffect,
								Actions.run(new Runnable() {

									public void run() {
										if (j == s) game.setScreen(screen);

									}
								}))); // end of addAction
					}
				} // end for
			}// end if
		}

	@Override
	public void hide() {
		this.stage.dispose();
		this.stage.getActors().clear();
	}

	public void buildButtons() {
	}

}
