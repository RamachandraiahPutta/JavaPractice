package com.practice.threads;

public class ThreadLifeCycle {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println(t.getState());

        t.start();
        System.out.println(t.getState());
    }
}
