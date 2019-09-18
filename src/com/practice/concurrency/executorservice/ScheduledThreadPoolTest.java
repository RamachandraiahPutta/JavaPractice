package com.practice.concurrency.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

	public static void main(String[] args) {
		/*
		 * 1)Fixed Thread Pool 2)Cached Thread Pool 3)Scheduled Thread Pool 4) Single
		 * Thread Executor
		 * 
		 * Scheduled Thread Pool: a) creates a thread pool with initial number of
		 * threads b) uses a delay queue to hold the tasks c) schedule the tasks to run
		 * based on time delay (and retrigeer for fixedRate/fixedDelay) d)
		 */

		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

		// task to run after 10 second delay
		service.schedule(new Task(), 10, TimeUnit.SECONDS);

		// task to run repeatedly every 10 seconds
		service.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

		// task to run repeatedly 10 seconds after previous task completes
		service.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);
	}

}
