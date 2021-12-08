package com.cellar.greeter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.DoNotMock;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.DoNotMockException;

import com.cellar.greeter.constant.GreetMessage;

@TestInstance(Lifecycle.PER_CLASS)
public class GreeterTest {

	private Greeter sut;

	@BeforeAll
	public void setup() {
		sut = Greeter.getInstance();
	}

	@Test
	public void christmasGreetingsTest() throws IllegalAccessException {
		Assertions.assertEquals(GreetMessage.CHRISTMAS.getMessage(), sut.getGreetings());
	}

	@Test
	public void invalidMockTest() {
		Assertions.assertThrows(DoNotMockException.class, () -> Mockito.mock(UnmockableClass.class));
	}

	@DoNotMock
	private class UnmockableClass {}
}
