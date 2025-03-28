package com.practice.streams;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateStreamTest {

    public static void main(String[] args) {

        // primitive type array to Stream
        int[] ints = {1, 2, 3};
        IntStream intStream = Arrays.stream(ints);
        intStream.forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();

        // Variable args to Stream
        String[] strs = {"1", "2", "3"};
        Stream<String> stream = Stream.of(strs);
        stream.forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();

        Stream<Integer> infStream = Stream.iterate(1, i -> i + 1);
        infStream.filter(i -> i % 2 == 0).limit(5).forEach(n -> System.out.print(STR."\{n} "));
        System.out.println();

        AtomicInteger atomicInteger = new AtomicInteger(2);
        Supplier<Integer> evenNumGenerator = () -> atomicInteger.getAndAdd(2);

        Stream<Integer> infStream2 = Stream.generate(evenNumGenerator);
        infStream2.filter(i -> i % 2 == 0).limit(5).forEach(n -> System.out.print(STR."\{n} "));
    }

}
