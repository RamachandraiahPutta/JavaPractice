package com.practice.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {

	public static void main(String[] args) {
		/*
		 * 1)Fixed Thread Pool 2)Cached Thread Pool 3)Scheduled Thread Pool 4) Single Thread Executor
		 * 
		 * Cached Thread Pool:
		 * a) creates a thread pool 0 threads
		 * b) uses a Synchronous queue which can hold only 1 task
		 * c) if all threads are busy, then create a new thread for the task and place it in the pool
		 * d) If thread is idle for 60 secs then kills the thread
		 * */
		
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.execute(new Task());
		}
		System.out.println("Thread name:" + Thread.currentThread().getName());

	}

}
