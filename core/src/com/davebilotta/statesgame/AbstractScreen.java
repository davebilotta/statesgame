package com.davebilotta.statesgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davebilotta.statesgame.StatesGame.QuestionType;

public class AbstractScreen implements Screen {

	Texture bkg;
	Texture leftImage;
	
	Stage stage;
	TextButton[] menuButtons;
	BitmapFont font;	
	int w,h;
	
	@Override
	public void render(float delta) {
		stage.act();
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {

		Utils.log("show method");
		
		 w = Gdx.graphics.getWidth();
	     h = Gdx.graphics.getHeight();
		
		bkg = new Texture("chalkboard.jpg");
		leftImage = new Texture("Blank_US_Map.png");
		
		stage = new Stage(new ScreenViewport());
		stage.getViewport().update(w,h, true);		
		stage.clear();
		Gdx.input.setInputProcessor(stage);

		// DO these in StatesGame once?
		FileHandle fontFile = Gdx.files.internal("generic-medium-webfont.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);

		font = generator.generateFont(24);
		font.setColor(1f, 1f, 1f, 1);
		generator.dispose();
		
		buildBackground();
		buildImage();
		buildButtons();
		

	}

	// Background
	public void buildBackground() {
		
		stage.addActor(new Image(bkg));
	}
	
	// Builds image on left side of screen
	public void buildImage() {
		Image image = new Image(leftImage);
		image.setPosition(0, (h - 317)/2);
		// 512w x 317h
		stage.addActor(image);
	}
	
	public void buildButtons() {
		TextButton button;
		TextButtonStyle style = new TextButtonStyle();
		style.font = font;
		style.fontColor = Color.WHITE;
		int buttonW = 100;
		int buttonH = 50;
		int buttonSpacer = 25;
	
		String[] buttons = {"States","Capitals","State Facts"};

		// now position on screen
		int bTotal = (3 * buttonH) + (2 * buttonSpacer);   // total space the buttons take up
		int startY = (h - bTotal)/2;		
		int yPos = startY;
		int xPos = w - (int)(buttonW * 1.25);

		// 512w x 317h
		for (int i = 0; i < buttons.length; i++) {
			button = new TextButton(buttons[i], style);										
			button.setWidth(buttonW);
			button.setHeight(buttonH); 
			button.setName(buttons[i]);
			
			yPos = startY + ( ((i + 1) * buttonH) + (i * buttonSpacer) ); 
			button.setPosition(xPos, yPos);
			// add listener
			button.addListener(new InputListener() {
				public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
					String nm = event.getListenerActor().getName();
					if (nm == "States")	{
						Question quest = new Question(QuestionType.STATELEVEL);
					}
					if (nm == "Capitals") {
						Question quest = new Question(QuestionType.CAPITALLEVEL);
					}
					if (nm == "State Facts") {
						Question quest = new Question(QuestionType.FACTSLEVEL);
						// TODO: need to do setscreen here
					}
					
					return true;
				}});
			
			Utils.log("adding button at " + yPos);
			stage.addActor(button);
		} // end for	
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
