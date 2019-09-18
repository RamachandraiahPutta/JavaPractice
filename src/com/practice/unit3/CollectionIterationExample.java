package com.practice.unit3;

import java.util.Arrays;
import java.util.List;

import com.practice.unit1.Person;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Matthew", "Bronte", 45),
				new Person("Charlotte", "Arnold", 39));

		System.out.println("Using for loop");
		for (int i = 0; i < people.size(); i++) {
			System.out.println(people.get(i));
		}
		System.out.println();
		System.out.println("Using for in loop");
		for (Person person : people) {
			System.out.println(person);
		}
		System.out.println();
		
		System.out.println("using lambda for each loop");
		people.forEach(System.out::println);
		System.out.println();

		System.out.println("Üsing streams");
		people.stream().parallel().forEach(i -> System.out.println(i));

	}

}
