package com.davebilotta.statesgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


public class StatesGame extends Game {
	public static final boolean DEBUG = true;
	SpriteBatch batch;
	static State[] states;
	GameController controller;
	
    public static int WINDOW_WIDTH, WINDOW_HEIGHT;
    public static float SCALE_X,SCALE_Y;

	static BitmapFont smallFont,font, largeFont, scoreFont;
	static Texture bkg;
	
	public enum QuestionType {
		STATELEVEL, CAPITALLEVEL, FACTSLEVEL
	}
	public enum ScreenType {
		MAIN,LEVEL
	}

	@Override
	public void create() {
		WINDOW_WIDTH = Gdx.graphics.getWidth();
		WINDOW_HEIGHT = Gdx.graphics.getHeight();
		
		
		
		State.initStates();
		initFonts();
		bkg = new Texture("chalkboard-green.jpg");
		
		setScreen(new MainMenuScreen(this));
	}		
	
	public static void initFonts() {
				
		FileHandle fontFile = Gdx.files.internal("fonts/Bevan.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);

		smallFont = generator.generateFont(15);
		font = generator.generateFont(30);
		largeFont = generator.generateFont(48);
		scoreFont = generator.generateFont(200);
		
		generator.dispose();
	}


}