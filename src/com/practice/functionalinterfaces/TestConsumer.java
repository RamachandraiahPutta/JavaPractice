package com.practice.functionalinterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestConsumer {
	public static void main(String[] args) {
		Consumer<Integer> consumer1 = arg -> {
			System.out.println(arg + "OK");
		};

		consumer1.accept(10);

		Consumer<Object> consumer2 = (x) -> {
			System.out.println(x + "OK!!!");
		};
		consumer1.andThen(consumer2).accept(12);

		List<Book> list = Arrays.asList(new Book("This Side of Paradise", "F. Scott Fitzgerald"),
				new Book("The Beautiful and Damned", "F. Scott Fitzgerald"),
				new Book("The Great Gatsby", "F. Scott Fitzgerald"),
				new Book("Tender is the Night", "F. Scott Fitzgerald"),
				new Book("The Sound and the Fury", "William Faulkner"),
				new Book("Absalom, Absalom!", "William Faulkner"), new Book("Intruder in the Dust", "William Faulkner"),
				new Book("The Sun Also Rises", "Ernest Hemingway"), new Book("A Farewell to Arms", "Ernest Hemingway"),
				new Book("The Old Man and the Sea", "Ernest Hemingway"),
				new Book("For Whom the Bell Tolls", "Ernest Hemingway"),
				new Book("A Moveable Feast", "Ernest Hemingway"));

		list.stream().filter(distinctByKey(Book::getAuthor)).forEach(System.out::println);
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}
}

class Book {
	String name;
	String author;

	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + "]";
	}

}
