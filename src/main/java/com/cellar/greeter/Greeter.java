package com.cellar.greeter;

/**
 * Utility class providing methods aiming to wish you a merry Christmas.
 * 
 * @author Roberto Cella
 */
public final class Greeter {

	private static final String GREETINGS = "I wish you a merry Christmas!";

	public static Greeter getInstance() {
		return new Greeter();
	}

	public String getGreetings() {
		return GREETINGS;
	}

	private Greeter() {}
}
