package com.practice.streams;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class StatefulExample {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {

			Set<Integer> seen = ConcurrentHashMap.newKeySet();
			IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
			int sum = stream.parallel().map(
					// stateful behavioral parameter.
					e -> {
						if (seen.add(e)) {
							return e;
						} else
							return 0;
					}).sum();
			System.out.println(seen);
			System.out.println(sum);

		}
	}

}
