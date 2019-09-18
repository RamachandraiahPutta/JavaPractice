package com.practice.concurrency.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("Cores Count:" + coreCount);
		ExecutorService service = Executors.newFixedThreadPool(coreCount);
		for (int i = 0; i < 100; i++) {
			service.execute(new Task());
		}
		System.out.println("Thread name:" + Thread.currentThread().getName());
	}

}
