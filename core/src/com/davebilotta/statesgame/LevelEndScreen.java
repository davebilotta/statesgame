package com.davebilotta.statesgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LevelEndScreen implements Screen {

	Stage stage;
	int w, h;
	int score, levelSize, pointVal;
	TextButtonStyle style;
	LabelStyle labelStyle;
	StatesGame game;

	public LevelEndScreen(StatesGame game, int score, int levelSize, int pointVal) {
		
		this.game = game;
		this.score = score;
		this.levelSize = levelSize;
		this.pointVal = pointVal;

		this.style = new TextButtonStyle();
		this.labelStyle = new LabelStyle();

		style.font = StatesGame.font;
		style.fontColor = Color.ORANGE;

		labelStyle.font = StatesGame.font;
		labelStyle.fontColor = Color.WHITE;

	}

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
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();

		stage = new Stage(new ScreenViewport());
		stage.getViewport().update(w, h, true);
		stage.clear();
		Gdx.input.setInputProcessor(stage);

		
		// calculate ratio out of max possible score
		double ratio = (double) score / (levelSize * pointVal * 3);
				
				
		buildBackground();
		buildTopText();
		buildLevelTwoText(ratio);
		buildScore(ratio);
		buildBottomText();
	}

	public void buildBackground() {
		Image bkg = new Image(StatesGame.bkg);
		bkg.setName("background");
		stage.addActor(bkg);
		
		bkg.addListener(new buttonListener());
	}

	public void buildTopText() {
	
		LabelStyle style = new LabelStyle();
		style.font = StatesGame.font;
		style.fontColor = Color.RED;
		int textHeight = 80;
		int leftOffset = 10;

		// * Top Text */
		Label topText = new Label("Level Complete", style);
		topText.setBounds(leftOffset, (h - textHeight), w, textHeight);
		topText.setAlignment(1);
		topText.setWrap(true);
		topText.setName("topText");
		topText.addListener(new buttonListener());
		
		stage.addActor(topText);
	}

	public void buildLevelTwoText(double ratio) {
		// * Bottom Text */
		LabelStyle style = new LabelStyle();
		style.font = StatesGame.font;
		style.fontColor = Color.WHITE;
		int textHeight = 80;
		int leftOffset = 10;

		String text = calculateLevelTwoText(ratio);

		Label levelTwoText = new Label(text, style);
		levelTwoText.setBounds(leftOffset, (float)(h - textHeight * 1.5), w, textHeight);
		levelTwoText.setAlignment(1);
		levelTwoText.setWrap(true);
		levelTwoText.setName("levelTwoText");
		levelTwoText.addListener(new buttonListener());
		
		stage.addActor(levelTwoText);
	}

	public String calculateLevelTwoText(double ratio) {
		String text;
		
		if (ratio == 1.0) {
			text = "Perfect!";
		} else if (ratio >= 0.98) {
			text = "Almost perfect!";
		} else if (ratio >= 0.9) {
			text = "Awesome job!";
		} else if (ratio >= 0.8) {
			text = "Great!";
		} else if (ratio >= 0.50) {
			text = "Not bad!";
		} else if (ratio >= 0.30) {
			text = "You'll get there!";
		} else
			text = "Keep trying!";

		return text;
	}
	
	public void buildBottomText() {
		// * Bottom Text */
		LabelStyle style = new LabelStyle();
		style.font = StatesGame.smallFont;
		style.fontColor = Color.WHITE;
		int textHeight = 80;
		int leftOffset = 10;

		String text = "Tap to continue";

		Label bottomText = new Label(text, style);
		bottomText.setBounds(leftOffset, 0, w, textHeight);
		bottomText.setAlignment(1);
		bottomText.setWrap(true);
		bottomText.setName("bottomText");
		bottomText.addListener(new buttonListener());
		
		stage.addActor(bottomText);
	}

	public void buildScore(double ratio) {
		// * ScoreText */
		LabelStyle style = new LabelStyle();
		style.font = StatesGame.scoreFont;
		style.fontColor = Color.ORANGE;
		int textHeight = 160;
		int leftOffset = 10;

	//	String text = score + "";
		
		String text = Math.round(ratio * 100) + "%";

		Label scoreText = new Label(text, style);
		scoreText.setBounds(leftOffset,  (h - textHeight)/2, w, textHeight);
		scoreText.setAlignment(1);
		scoreText.setWrap(true);
		scoreText.setName("scoreText");
		scoreText.addListener(new buttonListener());
		
		stage.addActor(scoreText);
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



public class buttonListener extends InputListener {
	@Override
	public boolean touchDown(InputEvent event, float x, float y,int pointer, int button) {
		game.setScreen(new MainMenuScreen(game));
		return true;
	}
	
}

} // end of LevelEndScreen