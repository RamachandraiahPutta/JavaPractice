package com.practice.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.practice.unit1.Person;

public class StandardFunctionalInterfaceExample {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Matthew", "Bronte", 45),
				new Person("Charlotte", "Arnold", 39));

		// step1: sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// step2: create a method that prints all the elements in the list
		System.out.println("Printing All Persons:");
		performConditionally(people, p -> true, p -> System.out.println(p));

		// step3: create a method that prints all people that have last name begining
		// with C
		System.out.println("All persons last name starts with C");
		performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));
		System.out.println("All persons first name starts with C");
		performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p));

	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person person : people) {
			if (predicate.test(person)) {
				consumer.accept(person);
			}
		}

	}

}
