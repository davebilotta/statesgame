package com.davebilotta.statesgame;

public class Utils {

	public static void log (String message) {
		if (StatesGame.DEBUG) {
			System.out.println(message);
		}
	}
	
	public static void log (int message) {
		if (StatesGame.DEBUG) {
			System.out.println(message);
		}
	}
}
