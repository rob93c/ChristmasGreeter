package com.cellar.greeter.runner;

import com.cellar.greeter.Greeter;

public class Main {

	public static void main(String[] args) {
		System.out.println(Greeter.getInstance().getGreetings() + "\n");
	}
}
