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
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.davebilotta.statesgame.StatesGame.QuestionType;

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
	float transitionSpeed = 1.25f;

	public AbstractScreen(StatesGame game) {
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
		Image bkg = new Image(StatesGame.bkg);
		bkg.setName("background");
		stage.addActor(bkg);
	}

	public void buildTopText() {
		Label topText = new Label(this.topText, labelStyle);
		// TODO: Fix this
		int textHeight = 30;
		int leftOffset = 10;

		topText.setPosition(leftOffset, (h - textHeight));
		topText.setBounds(leftOffset, (h - textHeight), w, textHeight);
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
		if (correct) {
			Array<Actor> actors = stage.getActors();
			Actor a;
			if (!transitionOut) {
				for (int i = 0; i < actors.size; i++) {
					a = actors.get(i);
					// Don't transition background
					if(a.getName() != "background") {
						a.addAction(Actions.moveTo(a.getX() - 2000, a.getY(), transitionSpeed));
					}
				}
				transitionOut = true;

			}
		}

		stage.act();
		stage.draw();
	}

	@Override
	public void hide() {

	}

	public void buildButtons() {
	}

}
