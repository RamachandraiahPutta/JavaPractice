package com.practice.streams;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateStreamTest {

	public static void main(String[] args) {

		String[] strs = { "1", "2", "3" };
		Stream<String> stream = Arrays.stream(strs);
		stream.forEach(System.out::println);

		int[] ints = { 1, 2, 3 };
		IntStream intStream = Arrays.stream(ints);
		intStream.forEach(System.out::println);

		Stream<Integer> infStream = Stream.iterate(1, i -> i + 1);
		infStream.filter(i -> i % 2 == 0).limit(5).forEach(System.out::println);

		AtomicInteger atomicInteger = new AtomicInteger(2);
		Supplier<Integer> evenNumGenerator = () -> atomicInteger.getAndAdd(2);

		Stream<Integer> infStream2 = Stream.generate(evenNumGenerator);
		infStream2.filter(i -> i % 2 == 0).limit(5).forEach(System.out::println);
	}

}
