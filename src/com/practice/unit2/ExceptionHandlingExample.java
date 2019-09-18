package com.practice.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4 };
		int key = 0;

		process(numbers, key, wrapperLambda((v, k) -> System.out.println(v / k)));

	}

	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (k, v) -> {
			try {
				consumer.accept(k, v);
			} catch (Exception e) {
				System.out.println("Exception caught in wrapper lambda");
			}
		};
	}

	private static void process(int[] numbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : numbers) {
			consumer.accept(i, key);
		}

	}

}
