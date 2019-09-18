package com.practice.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ShortCircuitingStreamTest {

	public static void main(String[] args) {
		IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
		stream = stream.filter(i -> i % 3 == 0).peek(System.out::println);
		System.out.println(stream);
		OptionalInt opt = stream.findFirst();
		if (opt.isPresent()) {
			System.out.println(opt.getAsInt());
		}

		System.out.println("here");
		IntStream stream1 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallel();
		stream1 = stream1.filter(i -> i % 2 == 0);
		int[] array = stream1.toArray();
		IntStream.of(array).forEach(System.out::println);

	}

}
