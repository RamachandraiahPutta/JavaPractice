package com.practice.concurrency.locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLocks {
    public static void main(String[] args) {
        Counter counterWithStampedLock = new CounterWithStampedLock();

        // Create 2 threads that will increment the counter 100000 times each
        Thread t1 = new Thread(new IncrementTask(counterWithStampedLock));
        Thread t2 = new Thread(new IncrementTask(counterWithStampedLock));

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for thread 1 to finish
            t2.join(); // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + counterWithStampedLock.getCount());
    }
}

class CounterWithStampedLock implements Counter {
    private int count = 0;
    StampedLock lock = new StampedLock();

    public void increment() {
        long stamp = lock.writeLock(); // Acquire the write lock
        try {
            count++;
        } finally {
            lock.unlockWrite(stamp); // Release the write lock
        }
    }

    public int getCount() {
        long stamp = lock.tryOptimisticRead(); // Try to acquire an optimistic read lock
        int c = count;
        if (!lock.validate(stamp)) { // Check if the lock is still valid
            stamp = lock.readLock(); // Acquire a read lock
            try {
                c = count;
            } finally {
                lock.unlockRead(stamp); // Release the read lock
            }
        }
        return c;
    }
}
