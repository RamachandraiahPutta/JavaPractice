package com.practice.functionalinterfaces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaExamples {

    public static void main(String[] args) {

        // 1.Simple Runnable Example
        System.out.println("Simple Runnable Example");
        Runnable r = () -> System.out.println("Hello World!");
        new Thread(r).start();
        System.out.println();

        // 2. Simple Comparator Example
        System.out.println("Simple Comparator Example");
        Comparator<String> c = (s1, s2) -> s1.compareTo(s2);
        System.out.println(c.compare("Hello", "World"));
        System.out.println();

        // 3. Iterating over a list
        System.out.println("Iterating over a list");
        List<String> list = List.of("Apple", "Banana", "Orange");
        list.forEach(s -> System.out.println(s));
        System.out.println();

        // 4. Filtering a list with lambda
        System.out.println("Filtering a list with lambda");
        List<String> languages = List.of("Java", "Python", "JavaScript", "C", "C++", "Ruby", "Kotlin");
        List<String> filteredLanguages = languages.stream().filter(s -> s.startsWith("J")).collect(Collectors.toList());
        filteredLanguages.forEach(s -> System.out.println(s));
        System.out.println();

        // 5. Sorting a list with lambda
        System.out.println("Sorting a list with lambda");
        List<String> sortedLanguages = languages.stream().sorted().collect(Collectors.toList());
        sortedLanguages.forEach(s -> System.out.println(s));
        System.out.println();

        // 6. Sorting a list with lambda in reverse order
        System.out.println("Sorting a list with lambda in reverse order");
        List<String> reverseSortedLanguages = languages.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        reverseSortedLanguages.forEach(s -> System.out.println(s));
        System.out.println();

        // 7. Using a functional interface
        System.out.println("Using a functional interface");
        Calculator add = (a, b) -> a + b;
        Calculator subtract = (a, b) -> a - b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println(add.calculate(10, 5));
        System.out.println();

        // 8. Lambda with Map Interation
        System.out.println("Lambda with Map Interation");
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        System.out.println();

        // 9. Creating a thread using lambda
        System.out.println("Creating a thread using lambda");
        new Thread(() -> System.out.println("Hello from thread")).start();
        System.out.println();

        // 10. Lambda in comparator
        System.out.println("Lambda in comparator");
        List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Pineapple");
        words.sort(Comparator.comparingInt(String::length));
        words.forEach(s -> System.out.println(s));
        System.out.println();

        // 11. Method reference with lambda
        System.out.println("Method reference with lambda");
        words.forEach(System.out::println);
        System.out.println();

        // 12. Lambda with Optional
        System.out.println("Lambda with Optional");
        List<String> fruits = List.of("Apple", "Banana", "Orange", "Mango", "Pineapple");
        fruits.stream().filter(s -> s.startsWith("A")).findFirst().ifPresent(System.out::println);
        System.out.println();

        // 13. Lambda with Predicate
        System.out.println("Lambda with Predicate");
        Predicate<String> isEmpty = s -> s.isEmpty();
        System.out.println(isEmpty.test("Hello"));
        System.out.println(isEmpty.test(""));
        System.out.println();

        // 14. Lambda with Predicate and chaining
        System.out.println("Lambda with Predicate and chaining");
        Predicate<String> isNotEmpty = isEmpty.negate();
        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));
        System.out.println();

        // 15. Lambda with Predicate and chaining
        System.out.println("Lambda with Predicate and chaining");
        Predicate<String> isNotEmptyAndStartsWithA = isNotEmpty.and(s -> s.startsWith("A"));
        System.out.println(isNotEmptyAndStartsWithA.test("Apple"));
        System.out.println(isNotEmptyAndStartsWithA.test("Banana"));
        System.out.println(isNotEmptyAndStartsWithA.test(""));
        System.out.println();

        // 16. Lambda with BiFunction
        System.out.println("Lambda with BiFunction");
        BiFunction<Integer, Integer, Integer> addFunction = (a, b) -> a + b;
        System.out.println(addFunction.apply(10, 20));
        System.out.println();

        // 17. Lambda with Consumer
        System.out.println("Lambda with Consumer");
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Hello World!");
        System.out.println();

        // 18. Lambda with Consumer and chaining
        System.out.println("Lambda with Consumer and chaining");
        Consumer<String> printUpperCase = s -> System.out.println(s.toUpperCase());
        print.andThen(printUpperCase).accept("Hello World!");
        System.out.println();

        // 19. Lambda with Supplier
        System.out.println("Lambda with Supplier");
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get());
        System.out.println();

        // 20. Lambda with function
        System.out.println("Lambda with function");
        Function<String, Integer> length = s -> s.length();
        System.out.println(length.apply("Hello World!"));
        System.out.println();

        // 21. Lambda with function and chaining
        System.out.println("Lambda with function and chaining");
        Function<String, Integer> lengthAndSquare = length.andThen(i -> i * i);
        System.out.println(lengthAndSquare.apply("Hello World!"));
        System.out.println();

        // 22. Lambda with function and compose
        System.out.println("Lambda with function and compose");
        Function<Integer, Integer> square = i -> i * i;
        Function<Integer, Integer> squareAndLength = square.compose(i -> i + i);
        System.out.println(squareAndLength.apply(4));
        System.out.println();

        // 23. Lambda with function and identity
        System.out.println("Lambda with function and identity");
        Function<String, String> identity = Function.identity();
        System.out.println(identity.apply("Hello World!"));
        System.out.println();

        // 24. Lambda with UnaryOperator
        System.out.println("Lambda with UnaryOperator");
        UnaryOperator<Integer> squareNumber = i -> i * i;
        System.out.println(squareNumber.apply(4));
        System.out.println();

        // 25. Lambda with BinaryOperator
        System.out.println("Lambda with BinaryOperator");
        BinaryOperator<Integer> addNumbers = (a, b) -> a + b;
        System.out.println(addNumbers.apply(10, 20));
        System.out.println();

        // 26. Lambda with IntBinaryOperator
        System.out.println("Lambda with IntBinaryOperator");
        IntBinaryOperator addIntNumbers = (a, b) -> a + b;
        System.out.println(addIntNumbers.applyAsInt(10, 20));
        System.out.println();

        // 27. Lambda with Stream reduce
        System.out.println("Lambda with Stream reduce");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        System.out.println();

        // 28. Lambda with Stream filter
        System.out.println("Lambda with Stream filter");
        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        evenNumbers.forEach(System.out::println);
        System.out.println();

        // 29. Lambda with Stream map
        System.out.println("Lambda with Stream map");
        List<Integer> squareNumbers = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        squareNumbers.forEach(System.out::println);
        System.out.println();

        // 30. Lambda with Stream distinct
        System.out.println("Lambda with Stream distinct");
        List<Integer> duplicateNumbers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5);
        List<Integer> distinctNumbers = duplicateNumbers.stream().distinct().collect(Collectors.toList());
        distinctNumbers.forEach(System.out::println);
        System.out.println();

        // 31. Lambda with Stream sorted
        System.out.println("Lambda with Stream sorted");
        List<Integer> unsortedNumbers = List.of(5, 3, 1, 4, 2);
        List<Integer> sortedNumbers = unsortedNumbers.stream().sorted().collect(Collectors.toList());
        sortedNumbers.forEach(System.out::println);
        System.out.println();

        // 32. Lambda with Stream count
        System.out.println("Lambda with Stream count");
        numbers = List.of(1, 2, 3, 4, 5);
        long count = numbers.stream().count();
        System.out.println(count);
        System.out.println();

        // 33. Lambda with Stream allMatch
        System.out.println("Lambda with Stream allMatch");
        boolean allMatch = numbers.stream().allMatch(n -> n > 0);
        System.out.println(allMatch);
        System.out.println();

        // 34. Lambda with Stream anyMatch
        System.out.println("Lambda with Stream anyMatch");
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 4);
        System.out.println(anyMatch);
        System.out.println();

        // 35. Lambda with Stream noneMatch
        System.out.println("Lambda with Stream noneMatch");
        boolean noneMatch = numbers.stream().noneMatch(n -> n > 5);
        System.out.println(noneMatch);
        System.out.println();

        // 36. Lambda with Stream findFirst
        System.out.println("Lambda with Stream findFirst");
        numbers = List.of(1, 2, 3, 4, 5);
        numbers.stream().findFirst().ifPresent(System.out::println);
        System.out.println();

        // 37. Lambda with Stream findAny
        System.out.println("Lambda with Stream findAny");
        numbers.stream().findAny().ifPresent(System.out::println);
        System.out.println();

        // 38. Lambda for summing integers
        System.out.println("Lambda for summing integers");
        int sumOfNumbers = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumOfNumbers);
        System.out.println();

        // 39. Lambda for Max integer
        System.out.println("Lambda for Max integer");
        int maxNumber = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println(maxNumber);
        System.out.println();


        // 40. Lambda for Min integer
        System.out.println("Lambda for Min integer");
        int minNumber = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println(minNumber);
        System.out.println();

        // 41. Lambda for Joining Strings
        System.out.println("Lambda for Joining Strings");
        List<String> names = Arrays.asList("Ramu", "Geetha", "Vaishnav");
        String joinString = names.stream().collect(Collectors.joining(","));
        System.out.println(joinString);
        System.out.println();

        // 42. Lambda with Stream maptToInt
        System.out.println("Lambda with Stream maptToInt");
        names.stream().mapToInt(String::length).forEach(System.out::println);
        System.out.println();

        // 43. Lambda with Stream GroupingBy
        System.out.println("Lambda with Stream GroupingBy");
        Map<Integer, List<String>> groups = languages.stream().collect(Collectors.groupingBy(String::length));
        groups.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        // 44. Lambda with Stream Grouping By
        System.out.println("Lambda with Stream Grouping By");
        List<String> duplicateNames = Arrays.asList("Ramu", "Geetha", "Vaishnav", "Geetha", "Vaishnav", "Geetha", "Ramu");
        Map<String, Long> occurance = duplicateNames.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        occurance.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        // 45. Lambda with Stream PartitioningBy
        System.out.println("Lambda with Stream PartitioningBy");
        Map<Boolean, List<Integer>> partitions = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        partitions.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        // 46. Lambda with Stream partitionBy
        System.out.println("Lambda with Stream PartitioningBy");
        Map<Boolean, Long> partitionsWithOccurance = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0, Collectors.counting()));
        partitionsWithOccurance.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        // 47. Lambda with Stream flatMap
        words = Arrays.asList("Hello", "World");
        List<Character> chars = words.stream().flatMap(s -> s.chars().mapToObj(ch -> (char) ch)).collect(Collectors.toList());
        System.out.println(chars);
        System.out.println();


    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}
