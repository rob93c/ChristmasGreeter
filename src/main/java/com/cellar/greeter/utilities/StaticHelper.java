package com.cellar.greeter.utilities;

import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class StaticHelper {

	private static String firstElement;

	@SafeVarargs
	public static <T> List<T> getArgsAsList(final T... args) {
		List<T> argsList = List.of(args);

		firstElement = Stream.of(args)
				.filter(String.class::isInstance)
				.findFirst()
				.map(Object::toString)
				.orElse(StringUtils.EMPTY);

		return argsList;
	}

	public static String getFirstElement() {
		return firstElement;
	}

	private StaticHelper() {}
}
