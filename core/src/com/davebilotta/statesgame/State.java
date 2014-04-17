package com.davebilotta.statesgame;

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

		StatesGame.states[0] = new State("AL", "Alabama", "Montgomery", "");
		StatesGame.states[1] = new State("AK", "Alaska", "Juneau", "");
		StatesGame.states[2] = new State("AZ", "Arizona", "Phoenix", "");
		StatesGame.states[3] = new State("AR", "Arkansas", "Little Rock", "");
		StatesGame.states[4] = new State("CA", "California", "Sacramento", "");
		StatesGame.states[5] = new State("CO", "Colorado", "Denver", "");
		StatesGame.states[6] = new State("CT", "Connecticut", "Hartford", "");
		StatesGame.states[7] = new State("DE", "Delaware", "Dover", "");
		StatesGame.states[8] = new State("FL", "Florida", "Tallahassee", "");
		StatesGame.states[9] = new State("GA", "Georgia", "Atlanta", "");
		StatesGame.states[10] = new State("HI", "Hawaii", "Honolulu", "");
		StatesGame.states[11] = new State("ID", "Idaho", "Boise", "");
		StatesGame.states[12] = new State("IL", "Illinois", "Springfield", "");
		StatesGame.states[13] = new State("IN", "Indiana", "Indianapolis", "");
		StatesGame.states[14] = new State("IA", "Iowa", "Des Moines", "");
		StatesGame.states[15] = new State("KS", "Kansas", "Topeka", "");
		StatesGame.states[16] = new State("KY", "Kentucky", "Frankfort", "");
		StatesGame.states[17] = new State("LA", "Louisiana", "Baton Rouge", "");
		StatesGame.states[18] = new State("ME", "Maine", "Augusta", "");
		StatesGame.states[19] = new State("MD", "Maryland", "Annapolis", "");
		StatesGame.states[20] = new State("MA", "Massachusetts", "Boston", "");
		StatesGame.states[21] = new State("MI", "Michigan", "Lansing", "");
		StatesGame.states[22] = new State("MN", "Minnesota", "Saint Paul", "");
		StatesGame.states[23] = new State("MS", "Mississippi", "Jackson", "");
		StatesGame.states[24] = new State("MO", "Missouri", "Jefferson City","");
		StatesGame.states[25] = new State("MT", "Montana", "Helena", "");
		StatesGame.states[26] = new State("NE","Nebraska","Lincoln","");
		StatesGame.states[27] = new State("NV","Nevada","Carson City","");
		StatesGame.states[28] = new State("NH","New Hampshire","Concord","");
		StatesGame.states[29] = new State("NJ","New Jersey","Trenton","");
		StatesGame.states[30] = new State("NM","New Mexico","Santa Fe","");
		StatesGame.states[31] = new State("NY","New York","Albany","");
		StatesGame.states[32] = new State("NC","North Carolina","Raleigh","");
		StatesGame.states[33] = new State("ND","North Dakota","Bismarck","");
		StatesGame.states[34] = new State("OH","Ohio","Columbua","");
		StatesGame.states[35] = new State("OK","Oklahoma","Oklahoma City","");
		StatesGame.states[36] = new State("OR","Oregon","Salem","");
		StatesGame.states[37] = new State("PA","Pennsylvania","Harrisburg","");
		StatesGame.states[38] = new State("RI","Rhode Island","Providence","");
		StatesGame.states[39] = new State("SC","South Carolina","Columbia","");
		StatesGame.states[40] = new State("SD","South Dakota","Pierre","");
		StatesGame.states[41] = new State("TN","Tennessee","Nashville","");
		StatesGame.states[42] = new State("TX","Texas","Austin","");
		StatesGame.states[43] = new State("UT","Utah","Salt Lake City","");
		StatesGame.states[44] = new State("VT","Vermont","Montpelier","");
		StatesGame.states[45] = new State("VA","Virginia","Richmond","");
		StatesGame.states[46] = new State("WA","Washington","Olympia","");
		StatesGame.states[47] = new State("WV","West Virginia","Charleston","");
		StatesGame.states[48] = new State("WI","Wisconsin","Madison","");
		StatesGame.states[49] = new State("WY","Wyoming","Cheyenne","");
	}
}
