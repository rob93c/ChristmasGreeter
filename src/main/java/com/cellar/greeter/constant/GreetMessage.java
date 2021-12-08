package com.cellar.greeter.constant;

public enum GreetMessage {

	CHRISTMAS("""
			I wish you
			a merry Christmas!
			""");

	private String message;

	private GreetMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
