package com.practice.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExcerciseSolutionJava7 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Matthew", "Bronte", 45),
				new Person("Charlotte", "Arnold", 39));

		// step1: sort list by last name
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});
		// step2: create a method that prints all the elements in the list
		System.out.println("Printing All Persons:");
		printAll(people);
		// step3: create a method that prints all people that have last name begining
		// with C
		System.out.println("All persons last name starts with C");
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("C");
			}
		});
		System.out.println("All persons first name starts with C");
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getFirstName().startsWith("C");
			}
		});
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person person : people) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}

	}

	public static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}

interface Condition {
	boolean test(Person p);
}
