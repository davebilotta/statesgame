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
	
	public Question(QuestionType type) {
		this.questionType = type;
		buildChoices();
	}
	
	public Question(QuestionType type, int id) {
		this.questionType = type;
		buildChoices(id);
	}

	public void buildChoices() {
		this.choices = new State[NUM_CHOICES];
		
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
	
	public void buildChoices(int id) {
		this.choices = new State[NUM_CHOICES];
		
		switch (questionType) {
			case STATELEVEL:
				// TODO: This is the same as buildCapitalChoices - consolidate this
				buildStateChoices(id);
				break;
			case CAPITALLEVEL:
				buildCapitalChoices(id);
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

	// Old way
	public void buildStateChoices() {
		// add answer into list of choices
		// For this level type, choices are State names 
		
		State st = getOneState();
		
		Utils.log("State is " + st);
		int c = 0;
		
		// add 2 other random states
		for (int j = 0; j < NUM_CHOICES; j++) {
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
	
	// New way	
	public void buildStateChoices(int id) {
		// add answer into list of choices
		// For this level type, choices are State names 
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
	
	// Old way
	public void buildCapitalChoices() {
		// add answer into list of choices
		// For this level type, choices are State names 
		
		State st = getOneState();
		int c = 0;
		
		// add 2 other random states
		for (int j = 0; j < NUM_CHOICES; j++) {
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
		} // end for
				
		int a = (int) Math.round(Math.floor(Math.random() * 3));
		this.answer = choices[a];
		
		// temporarily return Texas
		//choices[0] =  StatesGame.states[42];
		//this.answer = choices[0];
	}
	
	// New way way
	public void buildCapitalChoices(int id) {
		// add answer into list of choices
		// For this level type, choices are State names 
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
	
	public void buildFactChoices() {

	}
	
	public void buildFactChoices(int id) {

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
