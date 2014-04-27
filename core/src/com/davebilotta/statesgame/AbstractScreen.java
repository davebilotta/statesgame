package com.davebilotta.statesgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davebilotta.statesgame.StatesGame.QuestionType;

public class AbstractScreen implements Screen {

	Stage stage;
	int w,h;
	boolean transitionOut;
	String[] buttons;
	
	int buttonW,buttonH,buttonSpacer;
	int startY,xPos,yPos;
	TextButtonStyle style;
	LabelStyle labelStyle;
	
	StatesGame game;
	String topText;
	
	public AbstractScreen (StatesGame game) {
		this.game = game;
		
		this.style = new TextButtonStyle();
		style.font = StatesGame.font;
		style.fontColor = Color.WHITE;
		
		this.labelStyle = new LabelStyle();
		labelStyle.font = StatesGame.font;
		labelStyle.fontColor = Color.ORANGE;
					
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
		stage.addActor(new Image(StatesGame.bkg));
	}
	
	public void buildTopText() {
		Label topText = new Label(this.topText,labelStyle);
		// TODO: Fix this
		int textHeight = 30;
		int leftOffset = 10;
		topText.setPosition(leftOffset, (h - textHeight));
		topText.setBounds(leftOffset, (h - textHeight), w, textHeight);
		topText.setWrap(true);
		stage.addActor(topText);
	}
	
	// Builds image on left side of screen
	public void buildImage() {
		Image image = new Image(new Texture("Blank_US_Map.png"));
		image.setPosition(0, (h - 317)/2);
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

	@Override
	public void hide() {
		
	}
	
	public void buildButtons() {
	}

}
