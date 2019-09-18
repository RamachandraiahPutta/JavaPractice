package com.practice.collections.queue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// holds the elements or objects which are to be processed by their priorities
		// doesn't allow null values to be stored in the queue

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.add(2);
		queue.add(4);
		queue.add(1);
		queue.add(3);
		System.out.println("head:" + queue.element());
		System.out.println("head:" + queue.peek());
		System.out.println("iterating the queue elements:");
		Iterator<Integer> itr = queue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		queue.remove();
		queue.poll();
		System.out.println("after removing two elements:");
		Iterator<Integer> itr2 = queue.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}

}
