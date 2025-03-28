package com.practice.threads;

import java.util.ArrayList;
import java.util.List;

/*
* A Virtual Thread is also an instance of java.lang.Thread. However, it is not tied to specific OS thread.
* Virtual thread still runs java code on an OS thread. However, when code running on a virtual thread blocks, the underlying OS thread can be used to run other virtual threads.
* */
public class VirtualThreadsExample {
    public static void main(String[] args) {

        int threadCount = 1000000000;
        List<Thread> threads = new ArrayList<>();

        Runnable runnable = () -> {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < threadCount; i++) {
            Thread thread = Thread.ofVirtual().unstarted(runnable);
            thread.setName(STR."Thread-\{i}");
            thread.start();
            System.out.println(STR."Thread started: \{thread.getName()}");
            threads.add(thread);
        }

        threads.forEach(thread -> {
            try {
                thread.join();
                System.out.println(STR."Thread Completed: \{thread.getName()}");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
