package com.davebilotta.statesgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


public class StatesGame extends Game {
	public static final boolean DEBUG = false;  // enable this to turn on debugging in Console
	SpriteBatch batch;
	static State[] states;
		
    public static int WINDOW_WIDTH, WINDOW_HEIGHT;
    public static float SCALE_X,SCALE_Y;
    
    boolean n7;    // Flag that we're on nexus 7 or larger
    
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
		initFonts(this);
		bkg = new Texture("chalkboard-green.jpg");
		
		setScreen(new MainMenuScreen(this));
	}		
	
	public static void initFonts(StatesGame game) {
				
		FileHandle fontFile = Gdx.files.internal("fonts/Bevan.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);

		// Nexus 7 is 1280 x 736
		if (WINDOW_WIDTH >= 1280 && WINDOW_HEIGHT >= 736) {	
			game.n7 = true;
			
			smallFont = generator.generateFont(30);
			font = generator.generateFont(45);
			largeFont = generator.generateFont(64);
		}
		else {
			smallFont = generator.generateFont(15);
			font = generator.generateFont(30);
			largeFont = generator.generateFont(48);
		}
		
		// This is the same for all devices
		scoreFont = generator.generateFont(200);
		
		generator.dispose();
	}


}