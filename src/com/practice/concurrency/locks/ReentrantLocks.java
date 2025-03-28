package com.practice.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* Reentrant locks are similar to intrinsic locks, but they provide more flexibility and control over locking.
* A thread can acquire the same reentrant lock multiple times without causing a deadlock.
* The lock has a hold count that keeps track of the number of times the lock has been acquired.
* The lock is released only when the hold count reaches zero.
*
* Features:
*   Reentrancy: A thread can acquire the same lock multiple times.

    Fairness: Supports fair locking (first-come, first-served).

    Try Lock: Allows a thread to attempt to acquire the lock without blocking.

    Interruptible Locking: A thread can be interrupted while waiting for the lock.
*
* */
public class ReentrantLocks {
    public static void main(String[] args) {
        Counter counterWithReentrantLock = new CounterWithReentrantLock();

        // Create 2 threads that will increment the counter 100000 times each
        Thread t1 = new Thread(new IncrementTask(counterWithReentrantLock));
        Thread t2 = new Thread(new IncrementTask(counterWithReentrantLock));

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for thread 1 to finish
            t2.join(); // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + counterWithReentrantLock.getCount());
    }
}

class CounterWithReentrantLock implements Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}
