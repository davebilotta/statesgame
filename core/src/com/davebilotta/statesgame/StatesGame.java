package com.davebilotta.statesgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StatesGame extends Game {
	public static final boolean DEBUG = true;
	SpriteBatch batch;
	static State[] states;
	GameController controller;
	//private Stage stage;
	//private OrthographicCamera camera;
	//private QuestionType questionType;
	
	static BitmapFont font, font2;
	static Texture bkg;
	
	public enum QuestionType {
		STATELEVEL, CAPITALLEVEL, FACTSLEVEL
	}

	@Override
	public void create() {
		State.initStates();
		
		//FileHandle fontFile = Gdx.files.internal("fonts/generic-bold-webfont.ttf");
		FileHandle fontFile = Gdx.files.internal("fonts/Bevan.ttf");
		//FileHandle fontFile = Gdx.files.internal("fonts/ChunkFiveEx.ttf");
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);

		font = generator.generateFont(30);
		font2 = generator.generateFont(36);
		generator.dispose();
		
		bkg = new Texture("chalkboard-green.jpg");
		
		setScreen(new MainMenuScreen(this));
	}		


}