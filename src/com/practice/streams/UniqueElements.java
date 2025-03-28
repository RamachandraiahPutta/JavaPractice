package com.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class UniqueElements {

    public static <T> List<T> getUniqueElements(List<T> elements) {

        Set<T> seen = ConcurrentHashMap.newKeySet();

        return elements.stream().filter(e -> seen.add(e)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 7);
        List<Double> doubles = Arrays.asList(1.2, 1.3, 1.4, 1.5, 1.4, 1.3, 1.2, 1.7);
        List<String> strings = Arrays.asList("Ramu", "Ravi", "Nag", "Vamsi", "Srinu", "Vamsi", "Nag", "Ramu");

        System.out.println(getUniqueElements(integers));
        System.out.println(getUniqueElements(doubles));
        System.out.println(getUniqueElements(strings));

        strings.stream().distinct().forEach(System.out::println);
    }

}
