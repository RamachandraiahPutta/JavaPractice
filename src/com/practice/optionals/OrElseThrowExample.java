package com.practice.optionals;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OrElseThrowExample {

	public static void main(String[] args) {

		Supplier<NoSuchElementException> supplier = () -> new NoSuchElementException();

		String result = Stream.of("outlet", "puddle", "eraser").filter(s -> Character.isAlphabetic(s.charAt(0)))
				.findAny().orElseThrow(supplier);
		System.out.println(result);

		List<Integer> list = IntStream.range(1, 5).boxed().collect(Collectors.toList());
		System.out.println(list);
		System.out.println(list.getClass().getName());

	}

}
