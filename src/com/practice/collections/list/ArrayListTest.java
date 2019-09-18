package com.practice.collections.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		// It uses a dynamic array to store the elements
		// maintains insertion order and is non-synchronized
		// can contain duplicate elements.
		// allows random access because array works at the index basis.
		// manipulation is slow because a lot of shifting needs to occur if any element
		// is removed from the array list.

		ArrayList<String> list = new ArrayList<String>();// Creating arraylist
		list.add("Ravi");// Adding object in arraylist
		list.add("Vijay");
		list.add("Ravi");
		list.add("Ajay");
		list.add(null);
		list.add(null);
		// Traversing list through Iterator
		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
