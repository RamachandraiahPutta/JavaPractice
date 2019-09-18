package com.practice.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest {

	public static void main(String[] args) {
		/*
		 * 1)Fixed Thread Pool 2)Cached Thread Pool 3)Scheduled Thread Pool 4) Single Thread Executor
		 * 
		 * Fixed Thread Pool:
		 * a) creates a thread pool with fixed number of threads
		 * b) uses a blocking queue to maintain the tasks
		 * c) Each Thread fetches next task from queue and executes it 
		 * */
		
		ExecutorService service = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			service.execute(new Task());
		}
		System.out.println("Thread name:" + Thread.currentThread().getName());

	}

}
