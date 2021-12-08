package com.cellar.greeter;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class GreeterTest {

	private Greeter sut;

	@BeforeAll
	public void setup() {
		sut = Greeter.getInstance();
	}

	@Test
	public void greetingsTest() throws IllegalAccessException {
		Object expectedGreetings = FieldUtils.readStaticField(Greeter.class, "GREETINGS", true);

		Assertions.assertEquals(expectedGreetings, sut.getGreetings());
	}
}
