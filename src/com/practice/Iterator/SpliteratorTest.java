package com.practice.Iterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");
		Spliterator<String> s = list.spliterator();
		s.tryAdvance(System.out::println);
		System.out.println(" --- bulk traversal");
		s.forEachRemaining(System.out::println);

		System.out.println(" --- attempting tryAdvance again");
		boolean b = s.tryAdvance(System.out::println);
		System.out.println("Element exists: " + b);

		// 2222
		s = list.spliterator();
		Spliterator<String> s1 = s.trySplit();

		s.forEachRemaining(System.out::println);
		System.out.println("-- traversing the other half of the spliterator --- ");
		s1.forEachRemaining(System.out::println);

	}

}
