package com.practice.concurrency.locks;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* ReadWrite locks are used to manage access to a shared resource that is read more often than it is written.
* Multiple threads can read the resource concurrently, but only one thread can write to the resource at a time.
* This can improve performance in scenarios where reads are more frequent than writes.
*
* How It Works:

    Read Lock: Allows multiple threads to read simultaneously.

    Write Lock: Allows only one thread to write and blocks all reads and writes.
* */
public class ReadWriteLocks {
    public static void main(String[] args) {
        Counter counterWithReadWriteLock = new CounterWithReadWriteLock();

        // Create 2 threads that will increment the counter 100000 times each
        Thread t1 = new Thread(new IncrementTask(counterWithReadWriteLock));
        Thread t2 = new Thread(new IncrementTask(counterWithReadWriteLock));

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for thread 1 to finish
            t2.join(); // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + counterWithReadWriteLock.getCount());
    }
}

class CounterWithReadWriteLock implements Counter {
    private int count = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment() {
        lock.writeLock().lock(); // Acquire the write lock
        try {
            count++;
        } finally {
            lock.writeLock().unlock(); // Release the write lock
        }
    }

    public int getCount() {
        lock.readLock().lock();
        try {
            return count;
        } finally {
            lock.readLock().unlock();
        }
    }
}
