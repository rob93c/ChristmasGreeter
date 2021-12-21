package com.cellar.greeter;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.DoNotMock;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.exceptions.misusing.DoNotMockException;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cellar.greeter.constants.GreetMessage;
import com.cellar.greeter.utilities.StaticHelper;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class GreeterTest {

	private static final String FIRST_ELEMENT = "firstElement";

	@Mock
	private MockedStatic<StaticHelper> mockedHelper;

	private Greeter sut;

	@BeforeAll
	public void setup() {
		sut = Greeter.getInstance();
	}

	@Test
	public void christmasGreetingsTest() {
		Assertions.assertEquals(GreetMessage.CHRISTMAS.getMessage(), sut.getGreetings());
	}

	@Test
	public void invalidMockTest() {
		Assertions.assertThrows(DoNotMockException.class, () -> Mockito.mock(UnmockableClass.class));
	}

	@Test
	public void staticMockTest() {
		mockedHelper.when(StaticHelper::getFirstElement).thenReturn(FIRST_ELEMENT);
		mockedHelper.when(() -> StaticHelper.getArgsAsList(FIRST_ELEMENT)).thenReturn(Collections.emptyList());

		Assertions.assertEquals(FIRST_ELEMENT, StaticHelper.getFirstElement());
		List<String> argsList = StaticHelper.getArgsAsList(FIRST_ELEMENT);
		Assertions.assertTrue(argsList.isEmpty());
	}

	@DoNotMock
	private class UnmockableClass {}

}
