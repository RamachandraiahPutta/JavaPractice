package com.practice.threads;

import java.util.ArrayList;
import java.util.List;


/*
 * A platform thread is a thin wrapper around the OS thread. A platform thread runs java code on its underlying OS thread.
 * Platform thread captures its OS thread for the entire lifetime of the platform thread. Consequently, the no of available platform threads is limited by the no of available OS threads.
 *
 * */
public class PlatformThreadsExample {
    public static void main(String[] args) {

        int threadCount = 10000;
        List<Thread> threads = new ArrayList<>();

        Runnable runnable = () -> {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(runnable);
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
