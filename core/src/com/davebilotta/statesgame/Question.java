package com.davebilotta.statesgame;

import java.util.ArrayList;
import java.util.Collections;

import com.davebilotta.statesgame.StatesGame.QuestionType;

public class Question {

	public State answer; // the correct answer (may be a State name, or a capital, etc.)
	public State[] choices; // what are the available choices?
	QuestionType questionType; // what level? (State, Capitals, or Facts)
	private String imagePath; // image that displays on the left
	private String topText; // This is the text at the top (ie, the actual question)

	private static final int NUM_CHOICES = 3;
	
	public Question(QuestionType type, int id) {
		this.questionType = type;
		buildChoices(id);
	}

	public void buildChoices(int id) {
		this.choices = new State[NUM_CHOICES];
		
		switch (questionType) {
			case STATELEVEL:
				// TODO: This is the same as buildCapitalChoices - consolidate this
				buildStateCapitalChoices(id);
				break;
			case CAPITALLEVEL:
				buildStateCapitalChoices(id);
				break;
			case FACTSLEVEL:
				buildFactChoices(id);
				break;
			}
	}

	/* returns one random State */
	public State getOneState() {
		int n = (int) Math.round(Math.floor(Math.random() * StatesGame.states.length));
		
		return StatesGame.states[n];
		
	}

	public void buildStateCapitalChoices(int id) {
		// This is called in State and Capital modes 
		//Re-enable this to test particular state 
		//State st = StatesGame.states[25];
		
		State st = StatesGame.states[id];
		
		choices[0] = st;
		this.answer = st;
		
		for (int j = 1; j < NUM_CHOICES;j++) {
		boolean done = false;
		while (!done) {
			boolean ok = true;
		
			st = getOneState();
			for (int i = 0; i < choices.length; i++) {
				if (st == choices[i]) {
					ok = false;
				}
			}
			if (ok) done = true;
		}
		choices[j] = st;
		}

		// Rearrange button choices so answer isn't always in the same position
		choices = shuffleStates(choices);
				
	}
		
	public void buildFactChoices(int id) {

	}
	
	public State[] shuffleStates (State[] arr) { 
		// arr is array of States to shuffle
		ArrayList<State> states = new ArrayList<State>();
		State[] s = new State[arr.length];
		
		for (int i = 0; i < arr.length; i ++) {
			states.add(arr[i]);
		}
		Collections.shuffle(states);
		
		for (int i = 0; i < arr.length; i ++) {
			s[i] = states.get(i);
		}
		
		return s;
		
	}

	public String[] getCapitalNames() {
		String[] ret = new String[NUM_CHOICES];
		for (int i = 0; i < choices.length; i++) {
			ret[i] = choices[i].getCapital();
		}
		return ret;
	}

	public String[] getStateNames() {
		String[] ret = new String[NUM_CHOICES];
		for (int i = 0; i < choices.length; i++) {
			ret[i] = choices[i].getName();
		}
		return ret;
	}

	public String[] getFacts() {
		// TODO: This isn't done yet
		String[] ret = new String[NUM_CHOICES];
		for (int i = 0; i < choices.length; i++) {
			ret[i] = choices[i].getCapital();
		}
		return ret;
	}

}
