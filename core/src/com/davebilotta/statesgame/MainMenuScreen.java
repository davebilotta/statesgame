package com.davebilotta.statesgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.davebilotta.statesgame.StatesGame.QuestionType;
import com.davebilotta.statesgame.StatesGame.ScreenType;

public class MainMenuScreen extends AbstractScreen {

	public MainMenuScreen(StatesGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		this.game = game;
		this.leftImagePath = "Blank_US_Map.png";
		this.screenType = ScreenType.MAIN;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();

	}

	public void buildButtons() {
		TextButton button;

		buttons = new String[] { "Capitals", "States" };
		buttonW = 100;
		buttonH = 50;
		buttonSpacer = 25;

		AbstractScreen screen = this;
		
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

					transitionOut();
					
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
