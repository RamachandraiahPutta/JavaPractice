package com.practice.collections.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		// represents the LinkedList implementation of Set Interface
		// extends the HashSet class and implements Set interface
		// It maintains the insertion order

		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("Ravi");
		set.add("Vijay");
		set.add(null);
		set.add("Ravi");
		set.add("Ajay");
		set.add(null);
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
