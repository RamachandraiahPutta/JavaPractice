package com.practice.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Matthew", "Bronte", 45),
				new Person("Charlotte", "Arnold", 39));

		// step1: sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// step2: create a method that prints all the elements in the list
		System.out.println("Printing All Persons:");
		printConditionally(people, p -> true);

		// step3: create a method that prints all people that have last name begining
		// with C
		System.out.println("All persons last name starts with C");
		printConditionally(people, p -> p.getLastName().startsWith("C"));
		System.out.println("All persons first name starts with C");
		printConditionally(people, p -> p.getFirstName().startsWith("C"));
	}

	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for (Person person : people) {
			if (predicate.test(person)) {
				System.out.println(person);
			}
		}

	}

}
