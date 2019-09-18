package com.practice.concurrency.executorservice;

public class ThreadTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Task());
			thread.start();
		}
		System.out.println("Thread name:" + Thread.currentThread().getName());
	}

}

class Task implements Runnable {
	public void run() {
		System.out.println("Thread name:" + Thread.currentThread().getName());
	}
}
