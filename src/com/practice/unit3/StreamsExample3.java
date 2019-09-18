package com.practice.unit3;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample3 {

	public static void main(String[] args) throws IOException {
		IntStream.range(1, 10).forEach(System.out::println);

		System.out.println(IntStream.range(1, 10).sum());

		Stream.of("ava", "aneri", "alberto").sorted().findFirst().ifPresent(System.out::println);

		String[] names = { "Al", "Anit", "kushal", "brent", "sarika", "amanda", "hans", "shivika", "sarah" };
		Arrays.stream(names).filter(x -> x.startsWith("s")).sorted().forEach(System.out::println);

		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);

		List<String> people = Arrays.asList("Al", "Anit", "kushal", "brent", "sarika", "amanda", "hans", "shivika",
				"sarah");
		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);

		/*
		 * Stream<String> lines = Files.lines(Paths.get("StreamsExample1.java")); lines
		 * .sorted() .filter(x->x.length()>13) .forEach(System.out::println);
		 * lines.close();
		 */
		
		double total=Stream.of(7.3,1.5,4.8).reduce(0.0, (a,b)->a+b);
		System.out.println(total);

	}

}
