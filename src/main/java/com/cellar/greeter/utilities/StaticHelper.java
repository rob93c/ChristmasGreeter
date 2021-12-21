package com.cellar.greeter.utilities;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StaticHelper {

	private static String firstElement;

	@SafeVarargs
	public static <T> List<T> getArgsAsList(final T... args) {
		List<T> argsList = Arrays.asList(args);

		firstElement = Stream.of(args)
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
