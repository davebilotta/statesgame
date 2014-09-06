package com.davebilotta.statesgame;

import com.davebilotta.statesgame.StatesGame.QuestionType;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Question {

	//public String answer; // the correct answer (may be a State name, or a capital, etc.)
	//public String[] choices; // what are the available choices?
	public State answer; // the correct answer (may be a State name, or a capital, etc.)
	public State[] choices; // what are the available choices?
	QuestionType questionType; // what level? (State, Capitals, or Facts)
	private String imagePath; // image that displays on the left
	private String topText; // This is the text at the top (ie, the actual question)

	public Question(QuestionType type) {
		this.questionType = type;

		buildChoices();
	}

	public void buildChoices() {
		this.choices = new State[3];
		
		switch (questionType) {
			case STATELEVEL:
				// TODO: This is the same as buildCapitalChoices
				buildStateChoices();
				break;
			case CAPITALLEVEL:
				buildCapitalChoices();
				break;
			case FACTSLEVEL:
				buildFactChoices();
				break;
			}
	}

	/* Returns an array of random unique states by id */
	public State[] getRandomStates(int num) {
		State[] temp = new State[num];
		int s = StatesGame.states.length;

		//String current = this.answer;
		State current = this.answer;

		for (int i = 0; i < num; i++) {
			int n = (int) Math.round(Math.floor(Math.random() * s));
			// TODO: Need to make sure it doesn't match current either
			//while (StatesGame.states[n].getId() == current) {
			while (StatesGame.states[n] == current) {
				// grab a new one
				n = (int) Math.round(Math.floor(Math.random() * s));
			}
			//choices[i] = StatesGame.states[n].getId();
			choices[i] = StatesGame.states[n];
			System.out.println("another answer is "
					+ StatesGame.states[n].getId());
		}

		return temp;
	}

	/* returns one random State */
	public State getOneState() {
		int n = (int) Math.round(Math.floor(Math.random() * StatesGame.states.length));
		
		return StatesGame.states[n];
		
	}

	public void buildStateChoices() {
		// add answer into list of choices
		// For this level type, choices are State names 
		
		State st = getOneState();
		int c = 0;
		
		// add 2 other random states
		for (int j = 0; j < 3; j++) {
			boolean done = false;
		
			while (!done) {
				boolean ok = true;
			
				st = getOneState();
				for (int i = 0; i < choices.length; i++) {
					//if (st.getName() == choices[i]) {
					if (st == choices[i]) {
						ok = false;
					}
				}
				if (ok) done = true;
			}
			choices[j] = st;
		} // end for
		
		int a = (int) Math.round(Math.floor(Math.random() * 3));
		this.answer = choices[a];
		
	}
	
	// TODO: Consolidate this

	public void buildCapitalChoices() {
		// add answer into list of choices
		// For this level type, choices are State names 
		
		State st = getOneState();
		int c = 0;
		
		// add 2 other random states
		for (int j = 0; j < 3; j++) {
			boolean done = false;
		
			while (!done) {
				boolean ok = true;
			
				st = getOneState();
				for (int i = 0; i < choices.length; i++) {
					//if (st.getCapital() == choices[i]) {
					if (st == choices[i]) {
						ok = false;
					}
				}
				if (ok) done = true;
			}
			choices[j] = st;
		} // end for
				
		int a = (int) Math.round(Math.floor(Math.random() * 3));
		this.answer = choices[a];
		
		// temporarily return Texas
		//choices[0] =  StatesGame.states[42];
		//this.answer = choices[0];
	
		
	}
	
	public void buildFactChoices() {

	}

	public String[] getCapitalNames() {
		String[] ret = new String[3];
		for (int i = 0; i < choices.length; i++) {
			ret[i] = choices[i].getCapital();
		}
		return ret;
	}

	public String[] getStateNames() {
		String[] ret = new String[3];
		for (int i = 0; i < choices.length; i++) {
			ret[i] = choices[i].getName();
		}
		return ret;
	}

	public String[] getFacts() {
		// TODO: This isn't done yet
		String[] ret = new String[3];
		for (int i = 0; i < choices.length; i++) {
			ret[i] = choices[i].getCapital();
		}
		return ret;
	}

}
