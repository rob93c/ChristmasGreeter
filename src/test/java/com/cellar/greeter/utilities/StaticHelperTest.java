package com.cellar.greeter.utilities;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StaticHelperTest {

	private static final String VALID_ELEMENT = "validElement";
	private static final int INVALID_ELEMENT = 42;

	@Test
	public void getArgsAsListTestWithoutInput() {
		var result = StaticHelper.getArgsAsList();
		Assertions.assertTrue(result.isEmpty());
		Assertions.assertTrue(StaticHelper.getFirstElement().isEmpty());
	}

	@Test
	public void getArgsAsListTestWithValidInput() {
		var result = StaticHelper.getArgsAsList(VALID_ELEMENT, INVALID_ELEMENT);
		Assertions.assertEquals(VALID_ELEMENT, StaticHelper.getFirstElement());
		var expectedList = List.of(VALID_ELEMENT, INVALID_ELEMENT);
		Assertions.assertEquals(expectedList, result);
	}

	@Test
	public void getArgsAsListTestWithInvalidInput() {
		var result = StaticHelper.getArgsAsList(INVALID_ELEMENT);
		Assertions.assertTrue(StaticHelper.getFirstElement().isEmpty());
		var expectedList = List.of(INVALID_ELEMENT);
		Assertions.assertEquals(expectedList, result);
	}
}
