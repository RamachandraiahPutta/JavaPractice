package com.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReferenceTest {

	public static void main(String[] args) {

		List<String> names = Arrays.asList(" A", "    B ", "C", "D  ");

		Function<? super String, String> trimMapper = String::trim;

		names.stream().map(trimMapper).forEach(System.out::println);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		Function<? super Integer, String> intToStringMapper = Test::intToString;

		numbers.stream().map(intToStringMapper).forEach(System.out::println);

	}

}

class Test {
	public static String intToString(Integer i) {
		return i.toString();
	}
}
