package com.davebilotta.statesgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.davebilotta.statesgame.StatesGame.QuestionType;

public class MainMenuScreen extends AbstractScreen {

	public MainMenuScreen(StatesGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		this.game = game;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		
	}
	
	public void buildButtons() {
		TextButton button;
		//TextButtonStyle style = new TextButtonStyle();
		//style.font = StatesGame.font;
		//style.fontColor = Color.WHITE;
		//style.fontColor= Color.RED;
		
		//buttons = new String[] {"State Facts", "Capitals", "States"};
		buttons = new String[] {"Capitals", "States"};
		buttonW = 100;
		buttonH = 50;
		buttonSpacer = 25;
			
		// now position on screen
		int bTotal = (4 * buttonH) + (2 * buttonSpacer);   // total space the buttons take up
		startY = (this.h - bTotal)/2;		
		yPos = startY;
		xPos = 512 + (w - 512 - buttonW)/2;
	
	
	for (int i = 0; i < buttons.length; i++) {
	
		button = new TextButton(buttons[i],style);
		button.setName(buttons[i]);
		button.setWidth(buttonW);
		button.setHeight(buttonH); 
				
		yPos = startY + ( ((i + 1) * buttonH) + (i * buttonSpacer) ); 
		button.setPosition(xPos, yPos);
		
		// add listener
		button.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				String nm = event.getListenerActor().getName();
				
				//transitionOut();
				
				if (nm == "States")	{
					
					transitionOut(new LevelScreen(game,QuestionType.STATELEVEL));
				}
				if (nm == "Capitals") {
					transitionOut(new LevelScreen(game,QuestionType.CAPITALLEVEL));
				}
					//transitionOut = false;
					//correct = true;
					// TODO: Need to add a delay here
					//game.setScreen(new LevelScreen(game,QuestionType.CAPITALLEVEL));
					
					/*stage.getActors().get(0).addAction(Actions.sequence(Actions.fadeOut(2), Actions.run(new Runnable() {
					    public void run () {
					        System.out.println("Action complete!");
					    }
					}))); */
					//transitionOut();
					
					//game.setScreen(new LevelScreen(game,QuestionType.CAPITALLEVEL));
					
					
				if (nm == "State Facts") {
					transitionOut(new LevelScreen(game,QuestionType.FACTSLEVEL));
				}
				
				return true;
			}});
		
		stage.addActor(button);
	} // end for
	}

	
}
