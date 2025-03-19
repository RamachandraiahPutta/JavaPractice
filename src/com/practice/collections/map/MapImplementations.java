package com.practice.collections.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MapImplementations {
    public static void main(String[] args) {

        /* 1. HashMap
             Implements map using hash table
             Allow `null` keys and values
             Not synchronized (not thread-safe).
        */
        Map<String, Integer> map = new HashMap<>();

        // Adding elements
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        map.put(null, null);

        System.out.println("printing HashMap values");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        /* 2. LinkedHashMap
             Extends HashMap and maintains LinkedList for entries in the map
             Provides predictable iteration order.
             Not synchronized (not thread-safe).
        */
        map = new LinkedHashMap<>();
        // Adding elements
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        map.put(null, null);

        System.out.println("printing LinkedHashMap values");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        /* 3. TreeMap
             implements map using Red-Black tree
             maintains keys in sorted order
             doesn't allow null keys, but allows null values
             Not synchronized (not thread-safe).
        */
        map = new TreeMap<>(Comparator.reverseOrder());
        // Adding elements
        map.put("apple", 1);
        map.put("orange", 2);
        map.put("banana", null);
        map.put("grape", 4);


        System.out.println("printing TreeMap values");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        /* 4. Hashtable
             implements map using hashtable
             Doesn't allow null keys and values
             synchronized (thread-safe) but with significant performance overhead due to synchronization.
        */
        map = new Hashtable<>();
        // Adding elements
        map.put("apple", 1);
        map.put("orange", 2);
        map.put("banana", 3);
        map.put("grape", 4);


        System.out.println("printing Hashtable values");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

        /* 5. ConcurrentHashMap
             implements map with high concurrency and scalability
             Uses fine-grained locking (lock striping) to achieve thread safety without significant performance overhead.
             Doesn't allow null keys and values
             synchronized (thread-safe).
        */
        map = new ConcurrentHashMap<>();
        // Adding elements
        map.put("apple", 1);
        map.put("orange", 2);
        map.put("banana", 3);
        map.put("grape", 4);


        System.out.println("printing ConcurrentHashMap values");
        map.forEach((k, v) -> System.out.println(k + " " + v));
        System.out.println();

    }
}
