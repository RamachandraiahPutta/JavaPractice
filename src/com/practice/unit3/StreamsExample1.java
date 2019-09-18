package com.practice.unit3;

import java.util.Arrays;
import java.util.List;

import com.practice.unit1.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Matthew", "Bronte", 45),
				new Person("Charlotte", "Arnold", 39));
		long count = people.stream()
		.filter(p -> p.getLastName().startsWith("D"))
		.count();
		System.out.println(count);
	}

}
