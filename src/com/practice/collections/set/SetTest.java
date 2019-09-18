package com.practice.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// represents the unordered set of elements which doesn't allow us to store the
		// duplicate items.
		// can store at most one null value in Set
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new LinkedHashSet<String>();
		Set<String> s3 = new TreeSet<String>();
	}

}
