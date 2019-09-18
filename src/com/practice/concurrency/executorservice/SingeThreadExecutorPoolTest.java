package com.practice.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingeThreadExecutorPoolTest {

	public static void main(String[] args) {
		/*
		 * 1)Fixed Thread Pool 2)Cached Thread Pool 3)Scheduled Thread Pool 4) Single Thread Executor
		 * 
		 * Single Thread Executor Pool:
		 * a) creates a thread pool 1 thread
		 * b) uses a blocking queue to hold the tasks
		 * c) fetch next task from queue and execute it
		 * d) Recreates the thread if killed because of the task
		 * e) will be useful if you want to run tasks sequentially
		 * */
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 100; i++) {
			service.execute(new Task());
		}
		System.out.println("Thread name:" + Thread.currentThread().getName());

	}

}
