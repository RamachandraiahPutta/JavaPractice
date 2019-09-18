package com.practice.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollectorsTest {

	public static void main(String[] args) {
		List<String> letters = Arrays.asList("a", "b", "c", "d", "e", "f");
		List<String> names = Arrays.asList("Adam", "Brent", "Andrew", "Carl", "Doug", "Alex");
		List<Person> persons = populateData();

		// 1.joining
		System.out.println(letters.stream().collect(Collectors.joining(",")));

		// 2.toList
		System.out.println(names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList()));

		// 3.partitioningBy
		Predicate<Person> usResidentsPredicate = p -> p.getCountry().equalsIgnoreCase("us");
		System.out.println(persons.stream().collect(Collectors.partitioningBy(usResidentsPredicate)));

		// 4.groupingBy
		Function<Person, Boolean> usResidentsClassifier = p -> p.getCountry().equalsIgnoreCase("us");
		Function<Person, String> groupByCountryClassifier = p -> p.getCountry();
		System.out.println(persons.stream().collect(Collectors.groupingBy(usResidentsClassifier)));
		System.out.println(persons.stream().collect(Collectors.groupingBy(groupByCountryClassifier)));

		// 5.counting
		System.out.println(
				persons.stream().collect(Collectors.partitioningBy(usResidentsPredicate, Collectors.counting())));
		System.out
				.println(persons.stream().collect(Collectors.groupingBy(usResidentsClassifier, Collectors.counting())));
		System.out.println(
				persons.stream().collect(Collectors.groupingBy(groupByCountryClassifier, Collectors.counting())));

		// 6.mapping
		Function<Person, String> nameToUpperCase = p -> p.getName().toUpperCase();

		System.out.println(persons.stream().collect(Collectors.groupingBy(usResidentsClassifier,
				Collectors.mapping(nameToUpperCase, Collectors.toList()))));
		System.out.println(persons.stream().collect(Collectors.groupingBy(groupByCountryClassifier,
				Collectors.mapping(nameToUpperCase, Collectors.toList()))));

	}

	static List<Person> populateData() {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Person01", "US"));
		persons.add(new Person("Person02", "US"));
		persons.add(new Person("Person03", "Brazil"));
		persons.add(new Person("Person04", "US"));
		persons.add(new Person("Person05", "Brazil"));
		persons.add(new Person("Person06", "US"));
		persons.add(new Person("Person07", "Germany"));
		persons.add(new Person("Person08", "US"));
		return persons;
	}

}

class Person {
	private String name;
	private String country;

	public Person(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", country=" + country + "]";
	}

}
