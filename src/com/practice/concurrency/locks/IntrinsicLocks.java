package com.practice.concurrency.locks;


/*
 * Intrinsic locks are also known as monitor locks. Every object in Java has an intrinsic lock associated with it.
 * When a thread enters a synchronized block, it automatically acquires the intrinsic lock of the object.
 * The lock is released when the thread exits the synchronized block.
 * */
public class IntrinsicLocks {
    public static void main(String[] args) {
        Counter counter = new CounterWithIntrinsicLock();

        // Create 2 threads that will increment the counter 1000 times each
        Thread t1 = new Thread(new IncrementTask(counter));
        Thread t2 = new Thread(new IncrementTask(counter));

        t1.start();
        t2.start();

        try {
            t1.join(); // Wait for thread 1 to finish
            t2.join(); // Wait for thread 2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter: " + counter.getCount());
    }
}

interface Counter {
    void increment();

    int getCount();
}

class CounterWithIntrinsicLock implements Counter {
    private int count = 0;

    public synchronized void increment() {
        count++; // Thread-safe increment
    }

    public int getCount() {
        return count;
    }
}

class IncrementTask implements Runnable {
    private final Counter counter;

    public IncrementTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // Increment the counter 100000 times
        for (int i = 0; i < 100000; i++) {
            counter.increment();
        }
    }
}
