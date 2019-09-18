package com.practice.Iterator;

import java.util.Arrays;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Apple", "Banana", "Orange");
		list.iterator().forEachRemaining(System.out::println);
	}

}
