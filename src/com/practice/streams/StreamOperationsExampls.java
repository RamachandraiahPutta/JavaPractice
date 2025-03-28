package com.practice.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperationsExampls {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Intermediate Operations

        // 1. Filter operation
        numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();

        // 2. Map operation
        numbers.stream().map(n -> n * n).forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();

        // 3. reduce operation
        numbers.stream().reduce(Integer::sum).ifPresent(sum -> System.out.println("Sum: " + sum));

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(STR."Sum: \{sum}");

        // 4.flatMap operation
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );

        listOfLists.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .forEach(str -> System.out.print(STR."\{str} "));
        System.out.println();

        // 5. peek operation
        List<Integer> qubes = numbers.stream().map(n -> n * n * n).peek(n -> System.out.print(STR."\{n} ")).collect(Collectors.toList());
        System.out.println();

        // 6. distinct operation
        List<String> names = Arrays.asList("Ramu", "Ravi", "Nag", "Vamsi", "Srinu", "Vamsi", "Nag", "Ramu");
        names.stream().distinct().forEach(str -> System.out.print(STR."\{str} "));
        System.out.println();

        // 7. sorted operation
        names.stream().sorted().forEach(str -> System.out.print(STR."\{str} "));
        System.out.println();

        names.stream().sorted(Comparator.reverseOrder()).forEach(str -> System.out.print(STR."\{str} "));
        System.out.println();

        // 8. skip operation
        numbers.stream().skip(2).forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();

        // 9. limit operation
        numbers.stream().limit(6).forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();


        //Terminal Operations

        // 1. min operation
        numbers.stream().min(Comparator.naturalOrder()).ifPresent(n -> System.out.print(STR."Min: \{n}"));
        System.out.println();

        // 2. max operation
        numbers.stream().max(Comparator.naturalOrder()).ifPresent(n -> System.out.print(STR."Max: \{n}"));
        System.out.println();

        // 3. findFirst operation
        numbers.stream().filter(n -> n > 3).findFirst().ifPresent(n -> System.out.print(STR."FindFirst: \{n}"));
        System.out.println();

        // 4.findAny operation
        numbers.stream().filter(n -> n % 2 == 0).findAny().ifPresent(n -> System.out.print(STR."FirnAny: \{n}"));
        System.out.println();

        // 5. anyMatch operation
        boolean anyMatch = numbers.stream().anyMatch(n -> n > 7);
        System.out.print(STR."anyMatch: \{anyMatch}");
        System.out.println();

        // 6. allMatch operation
        boolean allMatch = numbers.stream().allMatch(n -> n > 1);
        System.out.print(STR."allMatch: \{allMatch}");
        System.out.println();

        // 7. count operation
        long evenCount = numbers.stream().filter(n -> n % 2 == 0).count();
        System.out.println(STR."EvenCount: \{evenCount}");

        // 8. sum operation
        sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(STR."Sum: \{sum}");

    }
}
