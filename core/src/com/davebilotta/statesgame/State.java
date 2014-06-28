package com.davebilotta.statesgame;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class State {

	private String id; // ie: MA (must be unique)
	private String name; // ie: Massachusetts
	private String capital; // ie: Boston
	private String imagePath; // ie: (name of image)
	private String[] facts; // list of questions about state

	public State(String id, String name, String capital, String imagePath) {
		this.setId(id);
		this.setName(name);
		this.setCapital(capital);
		this.setImagePath(imagePath);

	}

	/* Getters and setters */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	// Here is where the states are initialized
	public static void initStates() {
		StatesGame.states = new State[50];

		StatesGame.states[0] = new State("AL", "Alabama", "Montgomery", "state_images/alabama.png");
		StatesGame.states[1] = new State("AK", "Alaska", "Juneau", "state_images/alaska.png");
		StatesGame.states[2] = new State("AZ", "Arizona", "Phoenix", "state_images/arizona.png");
		StatesGame.states[3] = new State("AR", "Arkansas", "Little Rock", "state_images/arkansas.png");
		StatesGame.states[4] = new State("CA", "California", "Sacramento", "state_images/california.png");
		StatesGame.states[5] = new State("CO", "Colorado", "Denver", "state_images/colorado.png");
		StatesGame.states[6] = new State("CT", "Connecticut", "Hartford", "state_images/connecticut.png");
		StatesGame.states[7] = new State("DE", "Delaware", "Dover", "state_images/delaware.png");
		StatesGame.states[8] = new State("FL", "Florida", "Tallahassee", "state_images/florida.png");
		StatesGame.states[9] = new State("GA", "Georgia", "Atlanta", "state_images/georgia.png");
		StatesGame.states[10] = new State("HI", "Hawaii", "Honolulu", "state_images/hawaii.png");
		StatesGame.states[11] = new State("ID", "Idaho", "Boise", "state_images/idaho.png");
		StatesGame.states[12] = new State("IL", "Illinois", "Springfield", "state_images/illinois.png");
		StatesGame.states[13] = new State("IN", "Indiana", "Indianapolis", "state_images/indiana.png");
		StatesGame.states[14] = new State("IA", "Iowa", "Des Moines", "state_images/iowa.png");
		StatesGame.states[15] = new State("KS", "Kansas", "Topeka", "state_images/kansas.png");
		StatesGame.states[16] = new State("KY", "Kentucky", "Frankfort", "state_images/kentucky.png");
		StatesGame.states[17] = new State("LA", "Louisiana", "Baton Rouge", "state_images/louisiana.png");
		StatesGame.states[18] = new State("ME", "Maine", "Augusta", "state_images/maine.png");
		StatesGame.states[19] = new State("MD", "Maryland", "Annapolis", "state_images/maryland.png");
		StatesGame.states[20] = new State("MA", "Massachusetts", "Boston", "state_images/massachusetts.png");
		StatesGame.states[21] = new State("MI", "Michigan", "Lansing", "state_images/michigan.png");
		StatesGame.states[22] = new State("MN", "Minnesota", "Saint Paul", "state_images/minnesota.png");
		StatesGame.states[23] = new State("MS", "Mississippi", "Jackson", "state_images/mississippi.png");
		StatesGame.states[24] = new State("MO", "Missouri", "Jefferson City","state_images/missouri.png");
		StatesGame.states[25] = new State("MT", "Montana", "Helena", "state_images/montana.png");
		StatesGame.states[26] = new State("NE","Nebraska","Lincoln","state_images/nebraska.png");
		StatesGame.states[27] = new State("NV","Nevada","Carson City","state_images/nevada.png");
		StatesGame.states[28] = new State("NH","New Hampshire","Concord","state_images/newhampshire.png");
		StatesGame.states[29] = new State("NJ","New Jersey","Trenton","state_images/newjersey.png");
		StatesGame.states[30] = new State("NM","New Mexico","Santa Fe","state_images/newmexico.png");
		StatesGame.states[31] = new State("NY","New York","Albany","state_images/newyork.png");
		StatesGame.states[32] = new State("NC","North Carolina","Raleigh","state_images/northcarolina.png");
		StatesGame.states[33] = new State("ND","North Dakota","Bismarck","state_images/northdakota.png");
		StatesGame.states[34] = new State("OH","Ohio","Columbus","state_images/ohio.png");
		StatesGame.states[35] = new State("OK","Oklahoma","Oklahoma City","state_images/oklahoma.png");
		StatesGame.states[36] = new State("OR","Oregon","Salem","state_images/oregon.png");
		StatesGame.states[37] = new State("PA","Pennsylvania","Harrisburg","state_images/pennsylvania.png");
		StatesGame.states[38] = new State("RI","Rhode Island","Providence","state_images/rhodeisland.png");
		StatesGame.states[39] = new State("SC","South Carolina","Columbia","state_images/southcarolina.png");
		StatesGame.states[40] = new State("SD","South Dakota","Pierre","state_images/southdakota.png");
		StatesGame.states[41] = new State("TN","Tennessee","Nashville","state_images/tennessee.png");
		StatesGame.states[42] = new State("TX","Texas","Austin","state_images/texas.png");
		StatesGame.states[43] = new State("UT","Utah","Salt Lake City","state_images/utah.png");
		StatesGame.states[44] = new State("VT","Vermont","Montpelier","state_images/vermont.png");
		StatesGame.states[45] = new State("VA","Virginia","Richmond","state_images/virginia.png");
		StatesGame.states[46] = new State("WA","Washington","Olympia","state_images/washington.png");
		StatesGame.states[47] = new State("WV","West Virginia","Charleston","state_images/westvirginia.png");
		StatesGame.states[48] = new State("WI","Wisconsin","Madison","state_images/wisconsin.png");
		StatesGame.states[49] = new State("WY","Wyoming","Cheyenne","state_images/wyoming.png");
	}
	
	//  MOTTO|
	//  NICKNAME|
	//  BIRD|
	//  FLOWER|
	//  SENATOR1|  
	//  SENATOR2|
	//  SENATOR1-IMAGE|
	//  SENATOR2-IMAGE|
	//  GOVERNOR|
	//  POPULATION|
	//  LARGEST CITY|
	//  FLAG-IMAGE|
	//  SEAL-IMAGE|
}
