package com.davebilotta.statesgame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.davebilotta.statesgame.StatesGame.QuestionType;

public class LevelScreen extends AbstractScreen {

	Question question;
	String correctAnswer;
	
	public LevelScreen(StatesGame game, QuestionType type) {
		super(game);
		if (type == QuestionType.CAPITALLEVEL) {
			this.question = new Question(QuestionType.CAPITALLEVEL);
			this.correctAnswer = this.question.answer.getCapital();
			this.topText = "What is the capital of " + this.question.answer.getName() + "?";
		}
		if (type == QuestionType.STATELEVEL) {
			this.question = new Question(QuestionType.STATELEVEL);
			this.correctAnswer = this.question.answer.getName();
			this.topText = "What state is this?";
		}
		// TODO: Figure this out later
		if (type == QuestionType.FACTSLEVEL) {
			this.question = new Question(QuestionType.FACTSLEVEL);
			
		}
		Utils.log("The answer is " + correctAnswer);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		Utils.log("Level screen show");
	}
	
	@Override
	public void buildTopText() {
		// TODO Auto-generated method stub
		super.buildTopText();
	}
	
	@Override
	public void buildButtons() {
		TextButton button;
		
		//TextButtonStyle style = new TextButtonStyle();
		//style.font = StatesGame.font;
		//style.fontColor = Color.GREEN;
		
		//buttons = this.question.choices;
		if (this.question.questionType == QuestionType.CAPITALLEVEL) {
			buttons = this.question.getCapitalNames();
		}
		if (this.question.questionType == QuestionType.STATELEVEL) {
			buttons = this.question.getStateNames();
		}		
		if (this.question.questionType == QuestionType.FACTSLEVEL) {
			buttons = this.question.getFacts();
		}

		buttonW = 100;
		buttonH = 50;
		buttonSpacer = 25;
			
		// now position on screen
		int bTotal = (4 * buttonH) + (2 * buttonSpacer);   // total space the buttons take up
		startY = (this.h - bTotal)/2;		
		yPos = startY;
		xPos = 512 + (w - 512 - buttonW)/2;
	
		Utils.log("the correct answer is " + this.correctAnswer);
	
	for (int i = 0; i < buttons.length; i++) {
		button = new TextButton(buttons[i],style);										
		button.setWidth(buttonW);
		button.setHeight(buttonH); 
		button.setName(buttons[i]);
		
		yPos = startY + ( ((i + 1) * buttonH) + (i * buttonSpacer) ); 
		button.setPosition(xPos, yPos);
		final LevelScreen scr = this;
		
		final StatesGame gm = this.game;
		final QuestionType tp  = this.question.questionType;
		// add listener
		button.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				String nm = event.getListenerActor().getName();
				// TODO: This needs to check for the right answer
				Utils.log("You just clicked " + nm);
//				Utils.log("the correct answer is " + this.question.answer);
				//button.
				
				if (nm == correctAnswer)	{
					Utils.log("CORRECT!");			
					correct = true;
					transitionOut(new LevelScreen(gm,tp));
				}
				else {
					Utils.log("INCORRECT");
				}
				
				return true;
			}});
		
		stage.addActor(button);
	} // end for
	}

	
}
