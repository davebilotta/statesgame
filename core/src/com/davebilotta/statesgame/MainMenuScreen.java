package com.davebilotta.statesgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.davebilotta.statesgame.StatesGame.QuestionType;
import com.davebilotta.statesgame.StatesGame.ScreenType;

public class MainMenuScreen extends AbstractScreen {

	public MainMenuScreen(StatesGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		this.game = game;
		//this.leftImagePath = "Blank_US_Map.png";
		this.leftImagePath = "us.png";
		this.screenType = ScreenType.MAIN;
		this.topText = "Select Game Mode";
		//this.topText = "W: " + this.game.WINDOW_WIDTH + " H: " + this.game.WINDOW_HEIGHT;
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();

	}

	@Override
	public void buildTopText() {
		// TODO Auto-generated method stub
		super.buildTopText();
		
	}

	public void buildButtons() {
		TextButton button;

		buttons = new String[] { "Capitals", "States" };
		buttonW = 100;
		buttonH = 50;
		if (this.game.n7) buttonSpacer = 50;
		else buttonSpacer = 25;

		final AbstractScreen screen = this;
		
		int bTotal = ((buttons.length + 1) * buttonH)
				+ (buttons.length * buttonSpacer); // total space the buttons
													// take up
		startY = (this.h - bTotal) / 2;
		yPos = startY;
		xPos = 512 + (w - 512 - buttonW) / 2;

		for (int i = 0; i < buttons.length; i++) {

			button = new TextButton(buttons[i], style);
			button.setName(buttons[i]);
			button.setWidth(buttonW);
			button.setHeight(buttonH);

			yPos = startY + (((i + 1) * buttonH) + (i * buttonSpacer));
			button.setPosition(xPos, yPos);

			// add listener
			button.addListener(new InputListener() {
				public boolean touchDown(InputEvent event, float x, float y,
						int pointer, int button) {
					String nm = event.getListenerActor().getName();

					transitionOut(screen);
					
					if (nm == "States") game.setScreen(new LevelScreen(game,QuestionType.STATELEVEL));
					else if (nm == "Capitals") game.setScreen(new LevelScreen(game,QuestionType.CAPITALLEVEL));
						//else game.setScreen(new LevelScreen(game,QuestionType.FACTSLEVEL));

					return true;
				}
			});

			stage.addActor(button);
		} // end for
	}

}
