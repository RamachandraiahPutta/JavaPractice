package com.practice.concurrency.locks;

import java.util.concurrent.Semaphore;

public class Semphores {
    public static void main(String[] args) {
        Printer printer = new Printer(2); // Create a printer with 2 slots

        // Create 5 threads that will print documents
        Thread t1 = new Thread(new PrintTask(printer, "Document 1"));
        Thread t2 = new Thread(new PrintTask(printer, "Document 2"));
        Thread t3 = new Thread(new PrintTask(printer, "Document 3"));
        Thread t4 = new Thread(new PrintTask(printer, "Document 4"));
        Thread t5 = new Thread(new PrintTask(printer, "Document 5"));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join(); // Wait for thread 1 to finish
            t2.join(); // Wait for thread 2 to finish
            t3.join(); // Wait for thread 3 to finish
            t4.join(); // Wait for thread 4 to finish
            t5.join(); // Wait for thread 5 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Printer {
    private final Semaphore semaphore;

    public Printer(int slots) {
        semaphore = new Semaphore(slots);
    }

    public void print(String document) {
        try {
            semaphore.acquire();
            System.out.println("Printing: " + document);
            Thread.sleep(1000); // Simulate printing
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

class PrintTask implements Runnable {
    private final Printer printer;
    private final String document;

    public PrintTask(Printer printer, String document) {
        this.printer = printer;
        this.document = document;
    }

    @Override
    public void run() {
        printer.print(document);
    }
}
