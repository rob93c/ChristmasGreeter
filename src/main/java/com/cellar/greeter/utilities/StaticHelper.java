package com.cellar.greeter.utilities;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class StaticHelper {

	private static String firstElement;

	@SafeVarargs
	public static <T> List<T> getArgsAsArray(final T... args) {
		List<T> argsList = Arrays.asList(args);
		firstElement = argsList.stream()
				.filter(e -> e instanceof String)
				.findFirst()
				.map(Object::toString)
				.orElse(StringUtils.EMPTY);

		return argsList;
	}

	public static String getFirstElement() {
		return firstElement;
	}
}
